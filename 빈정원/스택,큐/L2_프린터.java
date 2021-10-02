import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        LinkedList<Integer> q = new LinkedList<>();
        for (int i : priorities) {
            q.offer(i);
        }
        
        Arrays.sort(priorities);
        int lastIdx = priorities.length - 1;
        int cnt = 0;    // 인쇄 횟수
        while (true) {
            int max = priorities[lastIdx - cnt];    // 현재 최댓값
            int maxIdx = q.indexOf(max);    // 현재 최댓값 idx (같은 값이 있으면 제일 앞)
            while (maxIdx != 0) {       // 인쇄가 가능할 때 까지 뒤로 옮기기
                q.offer(q.poll());
                maxIdx--;
                if (--location == -1)   // location 옮기기
                    location = q.size() - 1;
            }
            
            // 현재 최댓값이 0번째에 있으면 인쇄 가능
            cnt++;      // 인쇄 횟수 증가
            q.poll();   // 인쇄
            if (location == 0)  // 현재 인쇄한 문서가 내가 인쇄를 요청한 문서인 경우 break 
                break;
            else {
                if (--location == -1)   // 요청한 문서가 아닌 경우 location 옮기기
                    location = q.size() - 1;
            }
        }
        return cnt;
    }
}
