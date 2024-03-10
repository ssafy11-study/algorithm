import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] adjArray;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adjArray = new int[N + 1][N + 1];
		visit = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adjArray[from][to] = adjArray[to][from] = 1;
		}

		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				count++;
				visit[i] = true;
				dfs(i);
			}
		}
		System.out.println(count);
	}

	static void dfs(int v) {
		for (int i = 1; i <= N; i++) {
			if (adjArray[v][i] != 0) {
				if (!visit[i]) {
					visit[i] = true;
					dfs(i);
				}
			}
		}
	}
}