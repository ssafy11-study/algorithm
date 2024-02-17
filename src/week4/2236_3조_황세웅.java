import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		PriorityQueue<T> pq = new PriorityQueue<>((o1, o2) -> o2.v - o1.v);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n ; i++) {
			pq.offer(new T(i, Integer.parseInt(st.nextToken())));
		}
		
		boolean[] ans = new boolean[n];
		while (!pq.isEmpty()) {
			T curr = pq.poll();
			ans[curr.i] = true;
			sb.append(curr.i + 1).append("\n");
			if (--k == 0) break;
		}
		while (k-- > 0) {
			sb.append(0).append("\n");
		}
		
		for (int i = 0; i < n; i++) {
			if (!ans[i]) sb.append(0).append("\n");
			else sb.append(i + 1).append("\n");
		}
		System.out.println(sb);
	}
	
	static class T {
		int i;
		int v;
		
		T (int i, int v) {
			this.i = i;
			this.v = v;
		}
	}
}
