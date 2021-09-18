using System;
using System.Linq;

public class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 1234567890;
        
        answer = 0;
        for(var i=0; i < a.Count(); i++)
        {
            answer += a[i] * b[i];
        }
        
        return answer;
    }
}
