import java.util.Scanner;

public class Main {

	static int M, N;
	static boolean[] sieve;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		sieve = new boolean[N + 1];
		Eratosthenes();
		
		StringBuilder sb = new StringBuilder();
		for (int i = M; i <= N; i++) {
			if (!sieve[i]) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static void Eratosthenes() {
		sieve[0] = true;
		sieve[1] = true;
		
		for (int i = 2; i * i <= N; i++) {
			if (sieve[i]) continue;
			for (int j = i * i; j <= N; j += i) {
				sieve[j] = true;
			}
		}
	}

}
