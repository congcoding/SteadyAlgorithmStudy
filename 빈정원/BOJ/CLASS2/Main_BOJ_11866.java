import java.util.LinkedList;
import java.util.Scanner;

// 요세푸스 문제 0
public class Main_BOJ_11866 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			list.addLast(i);
		}
		StringBuilder sb = new StringBuilder("<");
		int idx = K - 1;
		for (int i = 1; i <= N; i++) {
			sb.append(list.remove(idx));
			if (list.isEmpty()) {
				sb.append(">");
			} else {
				sb.append(", ");
				idx = (idx + K - 1) % list.size();				
			}
		}
		System.out.println(sb);
	}

}
