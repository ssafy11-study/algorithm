import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int V, max, maxVertex;
	static List<W>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		V = Integer.parseInt(br.readLine());
		
		graph = new List[V + 1];
		for (int i = 1; i < V + 1; i++) {
			graph[i] = new ArrayList<>();
		}
				
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			while (true) {
				int v = Integer.parseInt(st.nextToken());
				if (v == -1) break;
				int w = Integer.parseInt(st.nextToken());
				graph[n].add(new W(v, w));
			}
		}
		
		visited = new boolean[V + 1]; dfs(1, 0);
		visited = new boolean[V + 1]; dfs(maxVertex, 0);
		System.out.println(max);
	}
	
	static void dfs(int v, int acc) {
		if (visited[v]) return;
		visited[v] = true;
		
		if (acc > max) {
			max = acc;
			maxVertex = v;
		}
		
		for (W next : graph[v]) {
			dfs(next.v, acc + next.w);
		}
	}
	
	static class W {
		int v;
		int w;
		
		W (int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
}