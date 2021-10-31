using System;

public class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Array.Sort(A); // 오름차순
        Array.Sort(B); // 오름차순
        Array.Reverse(B); // 내림차순

        for (var i = 0; i < A.Length; i++)
        {
            answer += A[i] * B[i];
        }
        
        return answer;
    }
}
