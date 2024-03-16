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
	
	static int N, m, mv;
	static boolean[] visited;
	static List<Path>[] graph;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		graph = new List[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[v1].add(new Path(v2, w));
			graph[v2].add(new Path(v1, w));
		}
		
		visited = new boolean[N + 1]; dfs(1, 0);
		visited = new boolean[N + 1]; dfs(mv, 0);
		System.out.println(m);
	}
	
	static void dfs(int v, int w) {
		if (visited[v]) return;
		visited[v] = true;
		
		if (w > m) {
			m = w;
			mv = v;
		}
		
		for (Path next : graph[v]) {
			dfs(next.v, w + next.w);
		}
	}
	
	static class Path {
		int v;
		int w;
		
		Path (int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
}