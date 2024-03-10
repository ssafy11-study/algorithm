import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static Node[] nodes;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nodes = new Node[N + 1]; // 0 dummy
		for (int i = 0; i < N + 1; i++) {
			nodes[i] = new Node();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			nodes[from].links.add(to);
			nodes[to].in += 1;
		}

		Deque<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			int in = nodes[i].in;
			if (in == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int current = queue.poll();
			Node curNode = nodes[current];
			sb.append(current).append(" ");
			for (int c : curNode.links) {
				nodes[c].in -= 1;
				if (nodes[c].in == 0) {
					queue.offer(c);
				}
			}
		}
		System.out.println(sb);
	}
}

class Node {
	int in = 0;
	List<Integer> links = new ArrayList<>();
}