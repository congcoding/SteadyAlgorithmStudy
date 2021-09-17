using System;
using System.Collections.Generic;

public class Solution {
    public int solution(string s) {
        int answer = 0;
        
        var numberWords = new List<string>(){"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
 
        for(var i = 0; i < numberWords.Count; i++) {
            s = s.Replace(numberWords[i], i.ToString());
        }
        
        answer = int.Parse(s);
        
        return answer;
    }
}
