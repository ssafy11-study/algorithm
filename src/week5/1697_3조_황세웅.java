import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, K;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[200_000];

		Queue<T> queue = new ArrayDeque<>();
		queue.offer(new T(N, 0));
		
		int ans = 0;
		while (!queue.isEmpty()) {
			T curr = queue.poll();
			if (curr.pos == K) {
				ans = curr.depth;
				break;
			}
			for (int i = -1; i <= 1; i++) {
				int next = curr.pos + i;
				if (i == 0) next *= 2;
				if (next < 0 || next >= 200_000) continue;
				if (visited[next]) continue;
				visited[next] = true;
				queue.offer(new T(next, curr.depth + 1));
			}
		}
		System.out.println(ans);
	}
	
	static class T {
		int pos;
		int depth;
		
		T(int pos, int depth) {
			this.pos = pos;
			this.depth = depth;
		}
	}
}