import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] p;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// parent 배열 자기 자신으로 초기화
		p = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			p[i] = i;
		}
        
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (cmd == 0) {
				union(a, b);
			} else {
				if (find(a) == find(b)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}
    
    	public static void union(int a, int b) {
		p[find(a)] = find(b);
	}
	
	public static int find(int a) {
		if (p[a] == a) return a;
		return p[a] = find(p[a]);
	}
    
}
