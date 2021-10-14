package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1952_수영장_DFS {

	static int T, min;
	static int[] prices = new int[4];
	static int[] plans = new int[13];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				plans[i] = Integer.parseInt(st.nextToken());
			}
			min = prices[3];	// 1년 이용권 사용
			dfs(1, 0);	// 1일, 1달, 3달 이용권 사용
			System.out.println("#" + t + " " + min);
		}
	}

	private static void dfs(int month, int sum) {
		// 현재 합이 현재 최솟값보다 크면 백트래킹
		if (min < sum) {
			return;
		}
		
		if (month > 12) {
			min = Math.min(min, sum);
			return;
		}
		
		if (plans[month] == 0) {
			// 0일인 경우 다음달로 이동
			dfs(month + 1, sum);			
		} else {
			// 0일이 아닌 경우 1일 이용권 사용 or 1달 이용권 사용 or 3달 이용권 사용
			dfs(month + 1, sum + plans[month] * prices[0]);			
			dfs(month + 1, sum + prices[1]);
			dfs(month + 3, sum + prices[2]);
		}
	}

}
