import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, K;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[] dist = new int[200_000];
		for (int i = 0; i < 200_000; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[N] = 0;

		PriorityQueue<Path> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		pq.offer(new Path(N, 0));

		while (!pq.isEmpty()) {
			Path curr = pq.poll();
			if (dist[curr.v] < curr.w) continue;
			for (int i = -1; i < 2; i++) {
				int next = curr.v + i;
				int path = curr.w + 1;
				if (i == 0) {
					next *= 2;
					path = curr.w;
				}
				if (next >= 200_000 || next < 0) continue;
				if (path < dist[next]) {
					dist[next] = path;
					pq.offer(new Path(next, path));
				}
			}
		}
		
		System.out.println(dist[K]);
	}

	static class Path {
		int v;
		int w;

		Path(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
}