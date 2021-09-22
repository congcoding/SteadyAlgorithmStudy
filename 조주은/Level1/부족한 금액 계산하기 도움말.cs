using System;

class Solution
{
    public long solution(int price, long money, int count)
    {
        long total = 0;
        for(var i=1; i <= count; i++ )
        {            
            total += (price * i);   
        }
        
        long result = 0;
        
        if((total - money) > 0)
        {
            result = total - money;
        }
        
        return result;
    }
}
