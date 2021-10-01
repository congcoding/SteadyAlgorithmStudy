import java.util.*;

class Solution {
    
    static int[] nums;
    static int n;
    static HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        n = numbers.length();
        for (int i = 1; i <= n; i++) {
            permutation(0, i, new StringBuilder(), new boolean[n], numbers);
        }
        
        for (int num : set) {
            if (isPrime(num)) answer++;
        }
        return answer;
    }
    
    public static void permutation(int cnt, int r, StringBuilder sb, boolean[] v, String str) {
        if (cnt == r) {
            set.add(Integer.parseInt(sb.toString()));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                v[i] = true;
                permutation(cnt + 1, r, sb.append(str.charAt(i)), v, str);
                permutation(cnt, r, sb.deleteCharAt(sb.length() - 1), v, str);
                v[i] = false;
            }
        }
    }
    
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
