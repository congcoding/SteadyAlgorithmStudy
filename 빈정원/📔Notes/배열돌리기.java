import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, R;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int r = Integer.parseInt(st.nextToken());
			switch (r) {
				case 1: op1(); break;
				case 2: op2(); break;
				case 3: op3(); break;
				case 4: op4(); break;
				case 5: op5(); break;
				case 6: op6(); break;
			}
		}
		print();
	}
	
	public static void print() {
		N = map.length;
		M = map[0].length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	// 상하 반전
	public static void op1() {
		N = map.length;
		M = map[0].length;
		for (int i = 0; i < N / 2; i++) {
			int tmp[] = new int[M];
			System.arraycopy(map[i], 0, tmp, 0, M);
			System.arraycopy(map[N - i - 1], 0, map[i], 0, M);
			System.arraycopy(tmp, 0, map[N - i - 1], 0, M);
		}
	}
	
	// 좌우 반전
	public static void op2() {
		N = map.length;
		M = map[0].length;
		for (int c = 0; c < M / 2; c++) {
			int tmp[] = new int[N];
			for (int r = 0; r < N; r++)
				tmp[r] = map[r][c];
			for (int r = 0; r < N; r++)
				map[r][c] = map[r][M - c - 1];
			for (int r = 0; r < N; r++)
				map[r][M - c - 1] = tmp[r];
		}
	}
	
	// 시계방향 90도 회전
	public static void op3() {
		N = map.length;
		M = map[0].length;
		int[][] res = new int[M][N];
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				res[r][c] = map[N - c - 1][r];
			}
		}
		map = res;
	}
	
	// 반시계방향 90도 회전
	public static void op4() {
		N = map.length;
		M = map[0].length;
		int[][] res = new int[M][N];
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				res[r][c] = map[c][M - r - 1];
			}
		}
		map = res;
	}
	
	// 시계방향 이동
	public static void op5() {
		N = map.length;
		M = map[0].length;
		int[][] tmp = new int[N / 2][M / 2];
		// 1 backup
		for (int r = 0; r < N / 2; r++) {
			for (int c = 0; c < M / 2; c++) {
				tmp[r][c] = map[r][c];
			}
		}
		// 4를 1로
		for (int r = 0; r < N / 2; r++) {
			for (int c = 0; c < M / 2; c++) {
				map[r][c] = map[r + N / 2][c];
			}
		}
		// 3을 4로
		for (int r = N / 2; r < N; r++) {
			for (int c = 0; c < M / 2; c++) {
				map[r][c] = map[r][c + M / 2];
			}
		}
		// 2를 3으로
		for (int r = N / 2; r < N; r++) {
			for (int c = M / 2; c < M; c++) {
				map[r][c] = map[r - N / 2][c];
			}
		}
		// tmp를 2로
		for (int r = 0; r < N / 2; r++) {
			for (int c = M / 2; c < M; c++) {
				map[r][c] = tmp[r][c - M / 2];
			}
		}
	}
	
	// 반시계방향 이동
	public static void op6() {
		N = map.length;
		M = map[0].length;
		int[][] tmp = new int[N / 2][M / 2];
		// 1 backup
		for (int r = 0; r < N / 2; r++) {
			for (int c = 0; c < M / 2; c++) {
				tmp[r][c] = map[r][c];
			}
		}
		// 2를 1로
		for (int r = 0; r < N / 2; r++) {
			for (int c = 0; c < M / 2; c++) {
				map[r][c] = map[r][c + M / 2];
			}
		}
		// 3을 2로
		for (int r = 0; r < N / 2; r++) {
			for (int c = M / 2; c < M; c++) {
				map[r][c] = map[r + N / 2][c];
			}
		}
		// 4를 3으로
		for (int r = N / 2; r < N; r++) {
			for (int c = M / 2; c < M; c++) {
				map[r][c] = map[r][c - M / 2];
			}
		}
		// tmp를 4로
		for (int r = N / 2; r < N; r++) {
			for (int c = 0; c < M / 2; c++) {
				map[r][c] = tmp[r - N / 2][c];
			}
		}
	}
	
}
