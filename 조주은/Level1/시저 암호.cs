using System.Linq;

public class Solution {
    public string solution(string s, int n) {
        string answer = "";
        
        var inputList = s.ToList();
        for(var i=0; i < s.Count(); i++)
        {
            if(s[i] != ' ')
            {
                var num = (int)s[i] + n;
                if((int)s[i] >= 65 && (int)s[i] <= 90)
                {
                    if(num > 90)
                    {
                        answer += (char) (64 + (num - 90)) +"";
                    }                
                    else
                    {
                        answer += (char)num + "";
                    }
                }
                else
                {
                    if(num > 122)
                    {
                        answer += (char) (96 + (num - 122)) +"";
                    }
                    else
                    {
                        answer += (char)num + "";
                    }
                }
            }
            else
            {
                answer += s[i];
            }
        }
        
        return answer;
    }
}
