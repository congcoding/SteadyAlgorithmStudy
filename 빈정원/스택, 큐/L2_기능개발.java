import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < speeds.length; i++) {
            q.offer((int)(Math.ceil((100.0 - progresses[i]) / speeds[i])));
        }
        while (!q.isEmpty()) {
            int cnt = 1;
            int cur = q.poll();
            while (!q.isEmpty() && cur >= q.peek()) {
                q.poll();
                cnt++;
            }
            ans.add(cnt);
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
