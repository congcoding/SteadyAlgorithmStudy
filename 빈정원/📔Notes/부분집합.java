import java.util.Scanner;

public class Main {

	static int N, S, ans;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		powerSet(0, new boolean[N]);
		System.out.println(S == 0 ? ans - 1 : ans);
	}

	private static void powerSet(int cnt, boolean[] v) {
		if (cnt == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (v[i]) {
					sum += arr[i];
				}
			}
			if (sum == S) {
				ans++;
			}
			return;
		}
		
		v[cnt] = true;
		powerSet(cnt + 1, v);
		v[cnt] = false;
		powerSet(cnt + 1, v);
	}

}
