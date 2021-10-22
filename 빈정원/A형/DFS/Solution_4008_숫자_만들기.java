import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Solution_4008_숫자_만들기 {
 
    static int T, N, min, max;
    static int[] numbers;
    static int[] operations;
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            numbers = new int[N];
            operations = new int[4];
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
             
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                operations[i] = Integer.parseInt(st.nextToken());
            }
             
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
             
            permutation(0, new int[N - 1]);
             
            answer.append("#").append(t).append(" ").append(max - min).append("\n");
        }
         
        bw.write(answer.toString());
        bw.flush();
        bw.close();
        br.close();
    }
 
    private static void permutation(int cnt, int[] nums) {
        if (cnt == N - 1) {
            int result = calculate(nums);
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }
         
        for (int i = 0; i < 4; i++) {
            if (operations[i] <= 0) continue;
            operations[i]--;
            nums[cnt] = i;
            permutation(cnt + 1, nums);
            operations[i]++;
        }
    }
 
    private static int calculate(int[] nums) {
        int result = numbers[0];
        for (int i = 1; i < N; i++) {
            int curOp = nums[i - 1];
            int curNum = numbers[i];
             
            switch (curOp) {
                case 0: { result += curNum; break; }
                case 1: { result -= curNum; break; }
                case 2: { result *= curNum; break; }
                case 3: { result /= curNum; break; }
            }
        }
        return result;
    }
 
}
