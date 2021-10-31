public class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        
        var isFinish = false;
        
        while(!isFinish)
        {
            isFinish = true;
            for(var i =0; i < arr.Length; i++)
            {
                if(answer % arr[i] != 0)
                {
                    answer++;
                    isFinish = false;
                }
            }
        }
        
        return answer;
    }
}
