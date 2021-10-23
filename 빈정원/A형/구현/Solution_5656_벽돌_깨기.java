package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution_5656_벽돌_깨기 {
 
    static int T, N, W, H, max;
    static int[][] origin, map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            origin = new int[H][W];
            max = 0;
            int brickCnt = 0;
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    origin[i][j] = Integer.parseInt(st.nextToken());
                    if (origin[i][j] != 0) brickCnt++;
                }
            }
            permutation(0, new int[N]);
            System.out.println("#" + t + " " + (brickCnt - max));
        }
 
    }
 
    public static void permutation(int cnt, int[] nums) {
        if (cnt == N) {
            map = new int[H][W];
            for (int i = 0; i < H; i++) {
                map[i] = Arrays.copyOf(origin[i], W);
            }
             
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += shoot(nums[i], new boolean[H][W]);
                down();
            }
 
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < W; i++) {
            nums[cnt] = i;
            permutation(cnt + 1, nums);
        }
    }
 
    public static int shoot(int c, boolean[][] v) {
        int[][] copy = new int[H][W];
        for (int i = 0; i < H; i++) {
            copy[i] = Arrays.copyOf(map[i], W);
        }
         
        Queue<int[]> q = new LinkedList<>();
        int r = 0;
        for (r = 0; r < H; r++) {
            if (copy[r][c] != 0) {
                q.add(new int[] {r, c, copy[r][c]});
                break;
            }
        }
         
        int cnt = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            map[cur[0]][cur[1]] = 0;
            v[cur[0]][cur[1]] = true;
            cnt++;
            for (int d = 0; d < 4; d++) {
                for (int i = 1; i < cur[2]; i++) {
                    int nr = cur[0] + dr[d] * i;
                    int nc = cur[1] + dc[d] * i;
                    if (nr < 0 || nr >= H || nc < 0 || nc >= W || v[nr][nc] || copy[nr][nc] == 0) continue;
                    map[nr][nc] = 0;
                    v[nr][nc] = true;
                    q.add(new int[] {nr, nc, copy[nr][nc]});
                }
            }
        }
        return cnt;
    }
     
    private static void down() {
        for (int r = H - 1; r >= 0; r--) {
            for (int c = 0; c < W; c++) {
                if (map[r][c] != 0) {
                    int idx = r + 1;
                    while (idx < H && map[idx][c] == 0) idx++;
                    if (idx != r + 1) {
                        map[--idx][c] = map[r][c];
                        map[r][c] = 0;                      
                    }
                }
            }
        }
    }
 
}
