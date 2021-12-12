public class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;
        var num = x;
        for(var i=1; i < n ; i++)
        {
            x += num;
            answer[i] = x;
        }
        
        return answer;
    }
}
