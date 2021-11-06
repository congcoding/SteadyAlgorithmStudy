public class Solution {
    public string solution(string s) {
        string answer = "";
        var min = 0;
        var max = 0;
        
        var arr = s.Split(' ');
        var cnt = 0;
        foreach(var num in arr)
        {
            if(cnt == 0)
            {
                min = int.Parse(num);
                max = int.Parse(num);
            }
            
            if( min > int.Parse(num))
            {
                min = int.Parse(num);
            }
            
            if(max < int.Parse(num))
            {
                max = int.Parse(num);
            }
            cnt++;
        }
        
        answer = min + " " + max;
        
        return answer;
    }
}
