import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int T, N, K, W;
	static int[] build, indegree, prevBuild;
	static List<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			build = new int[N + 1];
			prevBuild = new int[N + 1];
			indegree = new int[N + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < N + 1; i++) {
				build[i] = Integer.parseInt(st.nextToken());
			}
			
			graph = new List[N + 1];
			for (int i = 1; i < N + 1; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				graph[v1].add(v2);
				indegree[v2]++;
			}
			
			W = Integer.parseInt(br.readLine());
			
			Queue<Integer> queue = new ArrayDeque<>();
			for (int i = 1; i < N + 1; i++) {
				if (indegree[i] == 0) queue.offer(i);
			}
			
			while (!queue.isEmpty()) {
				int curr = queue.poll();
				if (curr == W) break;
				for (int next : graph[curr]) {
					if (--indegree[next] == 0) queue.add(next);
					prevBuild[next] = Math.max(prevBuild[next], build[curr] + prevBuild[curr]);
				}
			}
			sb.append(build[W] + prevBuild[W]).append("\n");
		}
		System.out.println(sb);
	}
}