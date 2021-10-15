class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        // 당첨 번호를 해시로 만들기
        boolean[] wins = new boolean[46];
        for (int i = 0; i < 6; i++) {
            wins[win_nums[i]] = true;
        }
        
        // 0과 당첨 번호를 각각 세기
        int zero = 0;
        int win = 0;
        for (int i = 0; i < 6; i++) {
            int cur = lottos[i];
            if (cur == 0) {
                zero++;
            } else if (wins[cur]) {
                win++;
            }
        }
        
        // 순위 계산
        int[] answer = new int[2];
        answer[1] = Math.min(7 - win, 6);
        answer[0] = Math.max(answer[1] - zero, 1);
        return answer;
    }
}
