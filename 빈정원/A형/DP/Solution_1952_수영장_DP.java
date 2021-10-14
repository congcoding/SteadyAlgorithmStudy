package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1952_수영장_DP {

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
				int day = Integer.parseInt(st.nextToken());
				// 1일 이용권 or 1달 이용권 사용
				plans[i] = Math.min(plans[i - 1] + day * prices[0], plans[i - 1] + prices[1]);
				// 3달 이용권 사용
				if (i >= 3) {	
					plans[i] = Math.min(plans[i], plans[i - 3] + prices[2]);				
				}
			}
			// 1년 이용권 사용
			min = Math.min(plans[12], prices[3]);
			System.out.println("#" + t + " " + min);
		}
	}

}
