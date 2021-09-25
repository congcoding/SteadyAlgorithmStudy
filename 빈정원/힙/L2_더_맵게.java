import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        int answer = 0;
        while (pq.size() > 1 && pq.peek() < K) {
            int cur = pq.poll();
            pq.add(cur + pq.poll() * 2);
            answer++;
        }
        return (pq.isEmpty() || pq.peek() < K) ? -1 : answer;
    }
}
