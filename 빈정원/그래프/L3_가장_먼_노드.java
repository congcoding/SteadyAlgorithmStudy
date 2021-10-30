import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int[] dist = new int[n + 1];
        ArrayList<Integer>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
            dist[i] = -1;
        }
        
        for (int i = 0; i < edge.length; i++) {
            adjList[edge[i][0]].add(edge[i][1]);
            adjList[edge[i][1]].add(edge[i][0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        dist[1] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : adjList[cur]) {
                if (dist[nxt] == -1) {
                    dist[nxt] = dist[cur] + 1;
                    q.add(nxt);
                }
            }
        }
        
        Arrays.sort(dist);
        int max = dist[n];
        int answer = 1;
        for (int i = n - 1; i >= 1; i--) {
            if (dist[i] == max) {
                answer++;
            } else {
                break;
            }
        }
        
        return answer;
    }
}
