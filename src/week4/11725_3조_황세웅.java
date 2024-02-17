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

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		
		List<Integer>[] graph = new List[n + 1];
		for (int i = 0; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			graph[n1].add(n2);
			graph[n2].add(n1);
		}
		
		
		boolean[] visited = new boolean[n + 1];
		visited[1] = true;
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1);

		int[] ans = new int[n + 1];
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			for (int next : graph[curr]) {
				if (visited[next]) continue;
				visited[next] = true;
				queue.offer(next);
				ans[next] = curr;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i < n + 1; i++) {
			sb.append(ans[i]).append("\n");
		}
		System.out.println(sb);
	}
}
