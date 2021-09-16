import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        // 완주자들을 map에 넣어줌
        for (int i = 0; i < completion.length; i++) {
            String cur = completion[i];
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        // 참가자들을 map에서 빼다가 -가 되거나 없으면 정답
        for (int i = 0; i < participant.length; i++) {
            String cur = participant[i];
            map.put(cur, map.getOrDefault(cur, 0) - 1);
            if (map.get(cur) < 0)
                return cur;
        }
        return "";
    }
}
