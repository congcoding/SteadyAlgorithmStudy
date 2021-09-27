using System;
using System.Linq;

public class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        for(var i=1; i<=9;i++)
        {
            answer += i;
        }
        
        for(var j=0; j < numbers.Count(); j++)
        {
            answer -= numbers[j];
        }
        
        return answer;
    }
}
