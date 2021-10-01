class Solution {
    
    static int ans;
    
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return ans;
    }
    
    public void dfs(int cnt, int sum, int[] numbers, int target) {
        if (cnt == numbers.length) {
            if (sum == target) {
                ans++;            
            }
            return;
        }
        dfs(cnt + 1, sum + numbers[cnt], numbers, target);
        dfs(cnt + 1, sum - numbers[cnt], numbers, target);
    }
}
