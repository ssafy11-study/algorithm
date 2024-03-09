import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T, V, E, W;
	static int[] dist;
	static List<Edge> path;

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			sb.append(solution() ? "YES" : "NO").append("\n");
		}
		System.out.print(sb);
	}
	
	static boolean solution() throws IOException {
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		path = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			path.add(new Edge(s, e, t));
			path.add(new Edge(e, s, t));
		}
		for (int i = E; i < E + W; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			path.add(new Edge(s, e, -t));
		}
		
		return bellmanford(1);
	}
	
	static boolean bellmanford(int start) {
		dist = new int[V + 1];
		
		for (int i = 0; i < V - 1; i++) {
			for (Edge curr : path) {
				if (dist[curr.v1] + curr.w < dist[curr.v2]) {
					dist[curr.v2] = dist[curr.v1] + curr.w;
					if (i == V - 1) return true;
				}
			}
		}
		for (Edge curr : path) {
			if (dist[curr.v1] + curr.w < dist[curr.v2]) return true;
		}
		return false;
	}
	
	static class Edge {
		int v1;
		int v2;
		int w;
		
		Edge (int v1, int v2, int w) {
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}
	}
}