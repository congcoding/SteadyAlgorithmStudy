import java.util.Scanner;

public class Main {

	static int N;
	static char[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
		}
		quadTree(0, 0, N);
		System.out.println(sb);
	}

	public static void quadTree(int r, int c, int size) {
		// 모두 같은 숫자로 이루어져 있는 경우 압축
		if (check(r, c, size)) {
			sb.append(map[r][c] - '0');
			return;
		}
		int half = size / 2;
		sb.append("(");
		quadTree(r, c, half);
		quadTree(r, c + half, half);
		quadTree(r + half, c, half);
		quadTree(r + half, c + half, half);
		sb.append(")");
	}

	// 모두 같은 숫자로 이루어져있는지 체크
	public static boolean check(int r, int c, int size) {
		char start = map[r][c];
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (map[i][j] != start) {
					return false;
				}
			}
		}
		return true;
	}

}
