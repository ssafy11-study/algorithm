import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	
	static List<Path>[] graph;
	static int n, m, x;
	static int[] back;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		graph = new List[n + 1];
		for (int i = 0; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			graph[s].add(new Path(e, t));
		}
		
		setBack();
		
		int max = 0;
		for (int i = 1; i < n + 1; i++) {
			max = Math.max(max, back[i] + toX(i));
		}
		
		System.out.println(max);
	}
	
	static int toX(int from) {
		int[] dist = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[from] = 0;
		
		PriorityQueue<Path> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
		pq.add(new Path(from, 0));
		
		while (!pq.isEmpty()) {
			Path curr = pq.poll();
			if (curr.weight > dist[curr.vertex]) {
				continue;
			}
			for (Path next : graph[curr.vertex]) {
				int newPath = curr.weight + next.weight;
				if (newPath < dist[next.vertex]) {
					dist[next.vertex] = newPath;
					pq.add(new Path(next.vertex, newPath));
				}
			}
		}
		return dist[x];
	}
	
	static void setBack() {
		back = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			back[i] = Integer.MAX_VALUE;
		}
		back[x] = 0;
		
		PriorityQueue<Path> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
		pq.add(new Path(x, 0));
		
		while (!pq.isEmpty()) {
			Path curr = pq.poll();
			if (curr.weight > back[curr.vertex]) {
				continue;
			}
			for (Path next : graph[curr.vertex]) {
				int newPath = curr.weight + next.weight;
				if (newPath < back[next.vertex]) {
					back[next.vertex] = newPath;
					pq.add(new Path(next.vertex, newPath));
				}
			}
		}
	}
	
	static class Path {
		int vertex;
		int weight;
		
		public Path(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
}