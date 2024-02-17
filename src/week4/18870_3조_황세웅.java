import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] ans = new int[n];
		
		PriorityQueue<X> pq = new PriorityQueue<>((o1, o2) -> o1.v - o2.v);
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			pq.offer(new X(i, Integer.parseInt(st.nextToken())));
		}
		
		int cnt = 0;
		int prev = pq.peek().v;
		while (!pq.isEmpty()) {
			X curr = pq.poll();
			if (curr.v > prev) {
				cnt++;
			}
			prev = curr.v;
			ans[curr.i] = cnt;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i : ans) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
	
	static class X {
		int i;
		int v;
		
		X(int i, int v) {
			this.i = i;
			this.v = v;
		}
	}
}
