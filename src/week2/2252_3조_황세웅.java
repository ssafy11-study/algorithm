import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<Integer>[] graph = new List[n + 1];
		for (int i = 0; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		int[] inDegree = new int[n + 1];
		List<String> ans = new ArrayList<>();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			inDegree[b]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i < n + 1; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			for (int next : graph[curr]) {
				if(--inDegree[next] == 0) {
					queue.add(next);
				}
			}
			ans.add(Integer.toString(curr));
		}
		
		System.out.println(String.join(" ", ans));
	}
}