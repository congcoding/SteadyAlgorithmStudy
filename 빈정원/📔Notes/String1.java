import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();	// 출력을 모아서 한번만 하기 위해서 사용
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder line = new StringBuilder();
			while (st.hasMoreTokens()) {
				// StringBuilder : append() 연속으로 사용 가능, reverse() 사용 가능
				line.append(new StringBuilder(st.nextToken()).reverse()).append(" ");
			}
			ans.append(line).append("\n");
		}
		System.out.println(ans);
	}

}
