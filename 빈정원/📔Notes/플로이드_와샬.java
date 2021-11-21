import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int dist[][];
	static final int INF = 987654321;
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        // dist를 INF로 초기화
        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
        	for (int j = 1; j <= N; j++) {
        		dist[i][j] = INF;
        	}
        }
        
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	if (dist[a][b] > c) {
        		dist[a][b] = c;
        	}
        }
        
        // 플로이드 와샬
        for (int k = 1; k <= N; k++) {
        	for (int i = 1; i <= N; i++) {
        		for (int j = 1; j <= N; j++) {
        			dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        		}
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
        	for (int j = 1; j <= N; j++) {
        		if (i == j || dist[i][j] == INF)
        			sb.append("0 ");
        		else
        			sb.append(dist[i][j] + " ");
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
	}

}
