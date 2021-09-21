import java.util.*;

class Solution {
    
    class Song implements Comparable<Song> {
        int cnt, idx;
        
        public Song(int cnt, int idx) {
            this.cnt = cnt;
            this.idx = idx;
        }
        
        @Override
        public int compareTo(Song s) {
            if (this.cnt == s.cnt)
                return this.idx - s.idx;
            return s.cnt - this.cnt;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> totalMap = new HashMap<>();    // 장르별 재생횟수 합 저장
        HashMap<String, ArrayList<Song>> map = new HashMap<>(); // 장르별 재생횟수 저장
        for (int i = 0; i < genres.length; i++) {
            totalMap.put(genres[i], totalMap.getOrDefault(genres[i], 0) + plays[i]);
            if (map.get(genres[i]) == null) {
               map.put(genres[i], new ArrayList<>());
            }
            map.get(genres[i]).add(new Song(plays[i], i));
        }

        // 장르별 재생횟수 합 내림차순 정렬 (value 기준)
        ArrayList<Map.Entry<String, Integer>> entryList = new ArrayList<>(totalMap.entrySet());
        entryList.sort((o1, o2) -> totalMap.get(o2.getKey()) - totalMap.get(o1.getKey()));
        
        // 많이 재생된 장르 순으로 돌면서
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < entryList.size(); i++) {
            ArrayList<Song> tmp = map.get(entryList.get(i).getKey());
            // 장르 내의 노래 재생 횟수를 정렬해서 2개 혹은 1개를 정답에 추가
            Collections.sort(tmp);
            ans.add(tmp.get(0).idx);
            if (tmp.size() != 1)
                ans.add(tmp.get(1).idx);
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
