import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// 수 찾기
public class Main_BOJ_1920 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			set.add(num);
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (set.contains(num)) {
				sb.append("1\n");
			} else {
				sb.append("0\n");
			}
		}
		System.out.println(sb);
	}

}
