import java.io.BufferedReader;
import java.io.InputStreamReader;

// 팰린드롬수
public class Main_BOJ_1259 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		while (!str.equals("0")) {
			String left = str.substring(0, str.length() / 2);
			String right = new StringBuilder(str.substring((int)Math.ceil(str.length() / 2.0))).reverse().toString();
			if (left.equals(right)) {
				sb.append("yes\n");
			} else {
				sb.append("no\n");
			}
			str = br.readLine();
		}
		System.out.println(sb);
	}

}
