import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Character> map = new HashMap();
		int N = sc.nextInt();
		int B = sc.nextInt();
		for (int i = 0; i <= 9; i++) {
			map.put(i, (char)(i + '0'));
		}
		for (int i = 10; i <= 35; i++) {
			map.put(i, (char)('A' + i - 10));
		}
		
		StringBuilder sb = new StringBuilder();
		while (N > 0) {
			sb.append(map.get(N % B));
			N /= B;
		}
		System.out.println(sb.reverse());
	}

}
