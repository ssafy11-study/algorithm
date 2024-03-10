import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, result;
	static int[][] edges;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		edges = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			edges[from][to] = 1;
			edges[to][from] = 1;
		}

		visit = new boolean[N + 1];
		dfs(1);

		result = 0;
		for (int i = 1; i <= N; i++) {
			if(i == 1) continue;
			if(visit[i]) {
				result++;
			}
		}
		System.out.println(result);
	}

	static void dfs(int v) {
		if (visit[v]) {
			return;
		}
		visit[v] = true;

		for (int i = 1; i < N + 1; i++) {
			if (edges[v][i] == 0) {
				continue;
			}
			dfs(i);
		}
	}
}