using System;
using System.Text;

public class Solution {
    public string solution(string s) {
        string answer = "";
        s= s.ToLower();
        var strArr = s.ToCharArray();
                
        for (int i = 0; i < strArr.Length; i++)
        {
            strArr[0] = Char.ToUpper(strArr[0]);
            if(strArr[i]==' ' && i+1 < strArr.Length)
            {
                strArr[i+1] = Char.ToUpper(strArr[i+1]);
            }                   
        }

        for (int i = 0; i < strArr.Length; i++)
        {
            answer += strArr[i];
        }
        
        return answer;
    }
}
