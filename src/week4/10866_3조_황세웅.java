import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		Deque<Integer> deque = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int v = 0;
			switch (st.nextToken()) {
			case "push_front":
				v = Integer.parseInt(st.nextToken());
				deque.offerFirst(v);
				break;
			case "push_back":
				v = Integer.parseInt(st.nextToken());
				deque.offerLast(v);
				break;
			case "pop_front":
				if (deque.isEmpty()) sb.append(-1).append("\n");
				else sb.append(deque.pollFirst()).append("\n");
				break;
			case "pop_back":
				if (deque.isEmpty()) sb.append(-1).append("\n");
				else sb.append(deque.pollLast()).append("\n");
				break;
			case "size":
				sb.append(deque.size()).append("\n");
				break;
			case "empty":
				sb.append(deque.isEmpty() ? 1 : 0).append("\n");
				break;
			case "front":
				if (deque.isEmpty()) sb.append(-1).append("\n");
				else sb.append(deque.peekFirst()).append("\n");
				break;
			case "back":
				if (deque.isEmpty()) sb.append(-1).append("\n");
				else sb.append(deque.peekLast()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}
}
