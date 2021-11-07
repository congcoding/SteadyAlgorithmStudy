using System;
using System.Linq;

public class Solution {
    public int[] solution(string s) {
        int[] answer = new int[] {};
        var zero = 0;
        var convertCnt = 0;
        
        while(!s.Equals("1"))
        {
            var zeroNum = s.Where(x => x == '0').Count();
            zero += zeroNum;
            
            var oneNum = s.Where(x => x == '1').Count();
            s = Convert.ToString(oneNum, 2);
            convertCnt++;
        }
        
        answer = new int[] {convertCnt, zero};
      
        return answer;
    }
}
