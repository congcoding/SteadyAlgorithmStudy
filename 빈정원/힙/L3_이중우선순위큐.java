import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            String cmd = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if (cmd.equals("I")) {  // 삽입
                minHeap.offer(num);
                maxHeap.offer(num);
            } else if (cmd.equals("D")) {
                if (minHeap.isEmpty()) continue;    // 비어있을 경우 무시
                if (num == 1) {     //최댓값 삭제
                    int max = maxHeap.poll();
                    minHeap.remove(max);
                } else {            // 최솟값 삭제
                    int min = minHeap.poll();
                    maxHeap.remove(min);
                }
            }
        }
        return minHeap.isEmpty() ? new int[2] : new int[] {maxHeap.poll(), minHeap.poll()};
    }
}
