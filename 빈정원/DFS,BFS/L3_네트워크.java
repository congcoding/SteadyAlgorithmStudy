import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] v = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (computers[i][j] == 1 && !v[i]) {
                    bfs(i, n, computers, v);
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    public void bfs(int num, int n, int[][] computers, boolean[] v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        v[num] = true;
        
        while (!q.isEmpty()) {
            num = q.poll();
            for (int i = 0; i < n; i++) {
                if (computers[num][i] == 0 || v[i]) continue;
                v[i] = true;
                q.add(i);
            }
        }
    }
}
