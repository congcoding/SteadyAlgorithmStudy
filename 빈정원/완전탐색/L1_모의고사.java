import java.util.*;

class Solution {
    
    static int[] arr1 = new int[] {1, 2, 3, 4, 5};
    static int[] arr2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] arr3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    static int score[] = new int[3];
    
    public int[] solution(int[] answers) {
        for (int i = 0; i < answers.length; i++) {
            if (arr1[i % 5] == answers[i]) score[0]++;
            if (arr2[i % 8] == answers[i]) score[1]++;
            if (arr3[i % 10] == answers[i]) score[2]++;
        }
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (score[i] == max) answer.add(i + 1);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
