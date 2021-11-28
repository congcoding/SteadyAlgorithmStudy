import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M;
	static int[][] map;
	static int[][] dist;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		dist = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		dist[0][0] = 1;
		q.offer(new int[] {0, 0});
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M 
					|| map[nr][nc] == 0 || dist[nr][nc] != 0) continue;
				q.offer(new int[] {nr, nc});
				dist[nr][nc] = dist[r][c] + 1;
			}
		}

		System.out.println(dist[N - 1][M - 1]);
	}

}
