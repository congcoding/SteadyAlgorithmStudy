using System;
using System.Linq;

class Solution 
{
    public int solution(int n) 
    {
        var cnt = Convert.ToString(n, 2).Where(x => x == '1').Count();
        
        while(true)
        {
            var tmpCnt = Convert.ToString(++n, 2).Where(x => x == '1').Count();
            
            if(tmpCnt == cnt)
            {
                break;
            }
        }

        return n;
     }
}
