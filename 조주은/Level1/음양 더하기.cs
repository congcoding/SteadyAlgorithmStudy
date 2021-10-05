using System;
using System.Linq;

public class Solution {
    public int solution(int[] absolutes, bool[] signs) {
        int answer = 0;
        
        for(var i=0; i < absolutes.Length; i++)
        {
            if(signs[i])
            {
                answer += absolutes[i];
            }
            else
            {
                answer -= absolutes[i];
            }
        }
        
        return answer;
    }
}
