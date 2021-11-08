using System;

public class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Array.Sort(A); 
        Array.Sort(B);
        var index = 0;
        
        for(var i =0; i < A.Length; i++)
        {
            if(B[i] > A[index])
            {
                answer += 1;
                index += 1;
            }
        }
        
        return answer;
    }
}
