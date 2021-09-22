using System;
using System.Linq;

public class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        var sum = 0;
        var array = d.OrderBy(i => i).ToList();
        
        for (var i = 0; i < array.Count(); i++)
        {
            sum += array[i];
            
            if(sum <= budget)
            {
                answer++;
            }
            else
            {
                break;
            }
        }
        
        return answer;
    }
}
