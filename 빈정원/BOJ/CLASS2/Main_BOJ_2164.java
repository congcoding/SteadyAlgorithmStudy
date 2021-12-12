import java.util.LinkedList;
import java.util.Scanner;

// 카드2
public class Main_BOJ_2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			list.addLast(i);
		}
		while (list.size() != 1) {
			list.removeFirst();
			list.addLast(list.removeFirst());
		}
		System.out.println(list.removeFirst());
	}

}
