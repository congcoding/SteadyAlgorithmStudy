import java.util.Scanner;

public class Main {

	static int M, N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		for (int i = M; i <= N; i++) {
			if (isPrime(i)) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
