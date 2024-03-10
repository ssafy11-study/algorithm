import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N, K;
	static int[] cost = new int[100001];
	static boolean[] visit = new boolean[100001];
	static PriorityQueue<Node> pqueue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		Node start = new Node(N, 0);
		cost[start.pos] = 0;
		pqueue.offer(start);

		while (!pqueue.isEmpty()) {
			Node cur = pqueue.poll();
			if (visit[cur.pos])
				continue;
			visit[cur.pos] = true;
			cost[cur.pos] = cur.cost;

			// 갈 수 있는 모든 위치
			if (cur.pos + 1 < cost.length) {
				pqueue.offer(new Node(cur.pos + 1, cur.cost + 1));
			}
			if (cur.pos - 1 >= 0) {
				pqueue.offer(new Node(cur.pos - 1, cur.cost + 1));
			}
			if (cur.pos * 2 < cost.length) {
				pqueue.offer(new Node(cur.pos * 2, cur.cost));
			}
		}

		System.out.println(cost[K]);
	}

	static class Node {
		int pos;
		int cost;

		Node(int pos, int cost) {
			this.pos = pos;
			this.cost = cost;
		}
	}
}