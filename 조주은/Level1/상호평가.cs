using System;
using System.Linq;

public class Solution {
    public string solution(int[,] scores) {
        string answer = "";

        for(var i=0; i < scores.GetLength(0); i++)
        {
            double avg = 0.0;
            int mineNum = scores[i, i];

            var max = -1;
            var min = 101;
            var sum = 0;

            for(var k = 0; k < scores.GetLength(0); k++)
            {
                if(k != i)
                {
                    if(max < scores[k, i])
                    {
                        max = scores[k, i];
                    }
                
                    if(min > scores[k, i])
                    {
                        min = scores[k, i];
                    }
                }
                                                
                sum += scores[k, i];  
            }
            
            if (mineNum > max || mineNum < min)
            {
                avg = (sum - mineNum) / (scores.GetLength(0) - 1);
            }
            else 
            {
               avg = sum / scores.GetLength(0);                    
            }
            
            if(avg >= 90)
            {
                answer += "A";
            } 
            else if(avg >= 80)
            {
                answer += "B";
            }
            else if(avg >= 70)
            {
                answer += "C";
            }
            else if(avg >= 50)
            {
                answer += "D";
            }
            else 
            {
                answer += "F";
            }           
        }
        
        return answer;
    }
}
