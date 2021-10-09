class Solution {
        
    public int solution(int m, int n, int[][] puddles) {
        // 물에 잠긴 지역 map에서 -1로 표시
        int[][] map = new int[n][m];
        for (int i = 0; i < puddles.length; i++) {
            if (puddles[i].length != 0)
                map[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
        }
        
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        // 윗칸, 왼쪽칸 더해서 계산
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (map[r][c] != -1) {
                    if (c - 1 >= 0) dp[r][c] += dp[r][c - 1] % 1000000007;
                    if (r - 1 >= 0) dp[r][c] += dp[r - 1][c] % 1000000007;
                    dp[r][c] %= 1000000007;
                }
            }
        }
        
        return dp[n - 1][m - 1];
    }
}
