using System;
using System.Linq;
using System.Collections.Generic;

public class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[] {};
        
        var minNum = arr.OrderByDescending(x => x).ToArray().Last();
                    
        if(arr.Count() == 1)
        {
            answer = new int[1] { -1 };
        }
        else
        {
            var idx = Array.IndexOf(arr, minNum);
                
            answer = arr.Where((source, index) => index != idx).ToArray();
        }
            
        return answer;
    }
}
