import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		
		List<Edge>[] graph = new List[v + 1];
		for (int i = 1; i < v + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		int[] dist = new int[v + 1];
		for (int i = 1; i < v + 1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[v1].add(new Edge(v2, weight));
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
		pq.add(new Edge(k, 0));
		dist[k] = 0;
		
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (curr.weight > dist[curr.vertex]) {
				continue;
			}
			for (Edge next : graph[curr.vertex]) {
				int newPath = curr.weight + next.weight;
				if (newPath < dist[next.vertex]) {
					dist[next.vertex] = newPath;
					pq.add(new Edge(next.vertex, newPath));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < v + 1; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
				continue;
			}
			sb.append(dist[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	static class Edge {
		int vertex;
		int weight;
		
		public Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
}
