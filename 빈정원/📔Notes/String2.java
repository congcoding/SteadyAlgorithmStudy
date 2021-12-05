import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static String[] croatianAlphabet = new String[] {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		for (int i = 0; i < croatianAlphabet.length; i++) {
			// replace(target, replacement) : target을 replacement로 교체 (전체)
			// replaceAll(regex(정규식), replacement) : regex를 replacement로 교체 (전체)
			// replaceFirst(regex(정규식), replacement) : regex를 replacement로 교체 (첫번째만)
			str = str.replace(croatianAlphabet[i], "_");
		}
		System.out.println(str.length());
	}

}
