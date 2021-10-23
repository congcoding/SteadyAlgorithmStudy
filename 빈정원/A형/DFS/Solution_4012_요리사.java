package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_4012_요리사 {
 
    static int T, N;
    static int min;
    static int taste[][];
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            taste = new int[N][N];
            min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    if (i < j)
                        taste[i][j] += tmp;
                    else
                        taste[j][i] += tmp;
                }
            }
            combination(0, 0, new boolean[N]);
            System.out.println("#" + t + " " + min);
        }
    }
 
    public static void combination(int start, int cnt, boolean[] v) {
        if (cnt == N / 2) {
            int sumA = 0;
            int sumB = 0;
            for (int i = 0; i < N; i++) {
                if (v[i]) {
                    for (int j = i + 1; j < N; j++) {
                        if (v[j]) sumA += taste[i][j];
                    }
                } else {
                    for (int j = i + 1; j < N; j++) {
                        if (!v[j]) sumB += taste[i][j];
                    }
                }
            }
            min = Math.min(min, Math.abs(sumA - sumB));
            return;
        }
        for (int i = start; i < N; i++) {
            v[i] = true;
            combination(i + 1, cnt + 1, v);
            v[i] = false;
        }
    }
 
}
