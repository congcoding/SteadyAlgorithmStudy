using System;

public class Solution {
    public string solution(int[] numbers) {
        string answer = "";
        
        Array.Sort(numbers, (x, y) => string.Compare(y.ToString() + x.ToString(), x.ToString() + y.ToString()));
        
        var zeroCnt = 0;
        foreach (var data in numbers)
        {
            if(data == 0)
            {
                zeroCnt++;
            }
        }
        
        if (zeroCnt == numbers.Length)
        {
            answer = "0";
        }
        else
        {
            answer = string.Join("", numbers);
        }
        
        return answer;
    }
}
