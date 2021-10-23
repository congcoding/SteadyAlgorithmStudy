package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4013_특이한_자석 {

	static final int CW = 1;
	static final int CCW = -1;
	static int T, K;
	static int[][] magnetics;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			K = Integer.parseInt(br.readLine());
			magnetics = new int[4][8];
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnetics[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken());
				int type = Integer.parseInt(st.nextToken());
				int rotateInfo[] = getRotateInfo(idx - 1, type);
				rotate(rotateInfo);
			}
			System.out.println("#" + t + " " + getScore());
		}
	}

	private static int getScore() {
		int score = 0;
		for (int i = 0; i < 4; i++) {
			if (magnetics[i][0] == 1) {
				score += Math.pow(2, i);
			}
		}
		return score;
	}

	private static void rotate(int[] rotateInfo) {
		for (int i = 0; i < 4; i++) {
			if (rotateInfo[i] == CW) {
				int tmp = magnetics[i][7];
				for (int j = 7; j >= 1; j--) {
					magnetics[i][j] = magnetics[i][j - 1];
				}
				magnetics[i][0] = tmp;
			} else if (rotateInfo[i] == CCW) {
				int tmp = magnetics[i][0];
				for (int j = 0; j < 7; j++) {
					magnetics[i][j] = magnetics[i][j + 1];
				}
				magnetics[i][7] = tmp;
			}
		}
	}

	private static int[] getRotateInfo(int idx, int type) {
		int[] rotateInfo = new int[4];
		rotateInfo[idx] = type;

		// 왼쪽 확인
		int copyIdx = idx;
		int copyType = type;
		while (--copyIdx >= 0 && magnetics[copyIdx][2] != magnetics[copyIdx + 1][6]) {
			copyType = -copyType;
			rotateInfo[copyIdx] = copyType;
		}
		
		// 오른쪽 확인
		copyIdx = idx;
		copyType = type;
		while (++copyIdx < 4 && magnetics[copyIdx][6] != magnetics[copyIdx - 1][2]) {
			copyType = -copyType;
			rotateInfo[copyIdx] = copyType;
		}
		
		return rotateInfo;
	}

}
