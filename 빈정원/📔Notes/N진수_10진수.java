import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Character, Integer> map = new HashMap();
		String N = sc.next();
		int B = sc.nextInt();
		for (int i = 0; i <= 9; i++) {
			map.put((char)(i + '0'), i);
		}
		for (int i = 10; i <= 35; i++) {
			map.put((char)('A' + i - 10), i);
		}
		
		int answer = 0;
		for (int i = 0; i < N.length(); i++) {
			char c = N.charAt(N.length() - i - 1);
			answer += map.get(c) * Math.pow(B, i);
		}
		System.out.println(answer);
	}

}
