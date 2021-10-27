public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        var first = 0;
        var second = 1;
        var cnt = 0;
        
        while(cnt < n)
        {
            var c = (first + second) % 1234567;
            first = second % 1234567;
            second = c % 1234567;
            cnt += 1;
        }
      
        
        return first;
    }
}
