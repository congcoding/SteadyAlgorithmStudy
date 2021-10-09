import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length + 1];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0)
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }
        
        int answer = 0;
        for (int i = 0; i < triangle.length; i++) {
            answer = Math.max(answer, dp[triangle.length - 1][i]);
        }
        return answer;
    }
}
