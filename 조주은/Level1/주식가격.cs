using System;

public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.Length];
        
        for(var i=0; i < answer.Length; i++)
        {
            for(var j= i+1; j<answer.Length; j++)
            {
                if(prices[i] > prices[j])
                {
                    answer[i] = j -1;
                    break;
                }
                
                if(j == answer.Length -1)
                {
                    answer[i] = j -1;
                }
            }            
        }
        
        return answer;
    }
}
