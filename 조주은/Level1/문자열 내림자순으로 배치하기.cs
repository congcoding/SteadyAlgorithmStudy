using System;
using System.Linq;

public class Solution {
    public string solution(string s) {
        
        var arr = s.ToList();
        var answer = string.Join("", arr.OrderByDescending(x => x).ToList());
        
        return answer;
    }
}
