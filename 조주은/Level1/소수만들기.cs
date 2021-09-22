using System;
using System.Linq;

class Solution
{
    public int solution(int[] nums)
    {
        int answer = 0;
        
        for(var i =0 ; i < nums.Length; i++)
        {
            for(var j = 1 + i ; j < nums.Length ; j ++)
            {
                for(var k = 1+ j; k < nums.Length; k++)
                {
                    var sum = nums[i] + nums[j] + nums[k];
                    var isPrimeNum = false;
                    
                    if(sum == 1)
                    {
                        isPrimeNum = false;
                    } 
                    else if (sum == 2)
                    {
                        isPrimeNum = true;
                    } 
                    else 
                    {
                        isPrimeNum = true;
                        for(var len = 2; len < sum; len++)
                        {
                            if(sum % len == 0)
                            {
                                isPrimeNum = false;
                                break;
                            }
                        }
                    }
                    
                    if(isPrimeNum)
                    {
                        answer++;
                    }
                    
                }
            }
        }

        return answer;
    }
}
