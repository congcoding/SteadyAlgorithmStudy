import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 의상의 종류별로 카운트
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        // product(의상 종류별 개수 + 1) - 1 (0개 입는 경우)
        int ans = 1;
        for (String key : map.keySet()) {
            ans *= map.get(key) + 1;
        }
        return ans - 1;
    }
}
