class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int r = 1; r <= yellow; r++) {
            if (yellow % r != 0) continue;
            int c = yellow / r;
            int border = (r + 2) * 2 + c * 2;
            if (border == brown) {
                answer[0] = c + 2;
                answer[1] = r + 2;
                break;
            }
        }
        return answer;
    }
}
