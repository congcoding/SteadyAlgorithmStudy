using System;
using System.Collections.Generic;

public class Solution {
    public string solution(string number, int k) {
        string answer = "";
        
        var numSize = number.Length - k;
        var temp = new List<int>(numSize);
        
        var start = 0;
        for(int i=0; i<numSize; i++) 
        {
            var maxNum = number[start];
            var maxIdx = start;
            for(int j=start; j<=k+i; j++) 
            {
                if(maxNum < number[j]) 
                {
                    maxNum = number[j];
                    maxIdx = j;
                }
            }
            
            start = maxIdx + 1;
            temp.Add((int)Char.GetNumericValue(maxNum));
        }
        answer = string.Join("",temp);
        
        return answer;
    }
}
