using System;
using System.Linq;

public class Solution {
    public string solution(string s) {
        string answer = "";
        
        var arr = s.ToList();
        
        if(arr.Count % 2 == 0)
        {
            answer = string.Format("{0}{1}",arr[arr.Count / 2 - 1], arr[arr.Count / 2]);
        }
        else
        {
            answer = string.Format("{0}", arr[arr.Count / 2]);
        }                                   
        
        return answer;
    }
}
