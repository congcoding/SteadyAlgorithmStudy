using System;

public class Solution {
    public int[,] solution(int[,] arr1, int[,] arr2) {
        
        int row = arr1.Length / arr1.GetLength(1);//행
        int col = arr2.Length / (arr2.Length / arr2.GetLength(1));//열
            
        int[,] answer = new int[row,col];
            
        for(var i=0; i < row; i++)
        {
            for(var j=0; j < col; j++)
            {
                var m = 0;
                while(m < arr2.GetLength(0))
                {
                    answer[i, j] += arr1[i, m] * arr2[m, j];
                    m++;
                }
            }
        }
        
        return answer;
    }
}
