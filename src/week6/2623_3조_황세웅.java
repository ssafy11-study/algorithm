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
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N, M;
	static List<Integer>[] graph;
	static int[] indegree;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		indegree = new int[N + 1];
		graph = new List[N + 1];
		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int prev = Integer.parseInt(st.nextToken());
			for (int j = 1; j < n; j++) {
				int v = Integer.parseInt(st.nextToken());
				graph[prev].add(v);
				indegree[v]++;
				prev = v;
			}
		}
		
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i < N + 1; i++) {
			if (indegree[i] == 0) queue.offer(i);
		}
		
		int cnt = 0;
		while (!queue.isEmpty()) {
			int v = queue.poll();
			sb.append(v).append("\n");
			cnt++;
			for (int next : graph[v]) {
				if (--indegree[next] == 0) queue.offer(next);
			}
		}
		System.out.println(cnt == N ? sb : 0);
	}
}