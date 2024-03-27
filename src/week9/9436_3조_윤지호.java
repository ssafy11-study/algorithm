import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, T;
	static Deque<Node> queue = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if (N == 0) {
				break;
			}
			T = Integer.parseInt(st.nextToken());

			queue.clear();
			for (int i = 1; i <= N; i++) {
				queue.offer(new Node(i, 0));
			}

			while (true) {
				// queue 내의 모든 cnt 가 0이 아니고 같은지 검사
				if (queue.peekFirst().cnt != 0 && (queue.peekFirst().cnt == queue.peekLast().cnt)) {
					sb.append(queue.size()).append(" ").append(queue.peekFirst().cnt).append("\n");
					break;
				}

				for (int j = 0; j < T; j++) {
					Node cur = queue.poll();
					cur.cnt++;
					queue.offer(cur);
				}
				queue.pollLast();
			}
		}

		System.out.println(sb);
	}

	static class Node {
		int n;
		int cnt;

		public Node(int n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}
	}
}