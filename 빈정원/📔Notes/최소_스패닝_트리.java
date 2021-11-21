import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Edge implements Comparable<Edge> {
		int start, end, cost;
		
		public Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(this.cost, e.cost);
		}
	}
	
	static int V, E;
	static int[] p;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
        // parent 배열을 자기 자신으로 초기화
        p = new int[V + 1];
		for (int i = 1; i <= V; i++) {
            p[i] = i;
        }
        
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
            // cost 오름차순으로 PQ에 저장
			pq.add(new Edge(start, end, cost));
		}
		
		int cnt = 0;
		int sum = 0;
		while (!pq.isEmpty()) {
			// 최소 스패닝 트리가 완성된 경우 break
            if (cnt == V - 1) break;
            
			Edge cur = pq.poll();
            
            // 이미 연결되어 있으면 continue
			if (find(cur.start) == find(cur.end)) continue;
            
            // 연결되어 있지 않으면 연결
			union(cur.start, cur.end);
			cnt++;
			sum += cur.cost;
		}
		System.out.println(sum);
	}

	public static void union(int a, int b) {
		p[find(a)] = find(b);
	}
	
	public static int find(int a) {
		if (p[a] == a) return a;
		return p[a] = find(p[a]);
	}
	
}
