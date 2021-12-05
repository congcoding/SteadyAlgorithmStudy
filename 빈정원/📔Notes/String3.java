import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String document = br.readLine();
		String word = br.readLine();
		int ans = 0;
		// contains(str) : str를 포함하면 true, 포함하지 않으면 false return
		while (document.contains(word)) {
			// substring(beginIndex) : beginIndex를 포함하여 끝까지 return
			// substring(beginIndex, endIndex) : beginIndex 포함, endIndex 전까지 return
			// indexOf(str) : str이 포함되어 있으면 시작하는 index return, 포함되어 있지 않으면 -1 return
			document = document.substring(document.indexOf(word) + word.length());
			ans++;
		}
		System.out.println(ans);
	}

}
