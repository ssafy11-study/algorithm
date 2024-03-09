import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int V, E;
	static int[][] dist;

	public static void main(String[] args) throws IOException {
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		dist = new int[V][V];
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
			dist[i][i] = 0;
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken()) - 1;
			int v2 = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			dist[v1][v2] = Math.min(dist[v1][v2], w);
		}
		
		for (int waypoint = 0; waypoint < V; waypoint++) {
			for (int start = 0; start < V; start++) {
				for (int end = 0; end < V; end++) {
					int path = dist[start][waypoint] + dist[waypoint][end];
					if (path >= 0) dist[start][end] = Math.min(dist[start][end], path);
				}
			}
		}
		
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (dist[i][j] == Integer.MAX_VALUE) sb.append(0).append(" ");
				else sb.append(dist[i][j]).append(" ");
			}
			sb.setCharAt(sb.length() - 1, '\n');
		}
		System.out.print(sb);
	}
}