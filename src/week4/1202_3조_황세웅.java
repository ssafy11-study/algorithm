import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static List<Integer> bags;

	public static void main(String[] args) throws IOException {		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		PriorityQueue<J> jewels = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			jewels.offer(new J(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		int[] bags = new int[k];
		for (int i = 0; i < k; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bags);
		
		long ans = 0;
		PriorityQueue<J> pq = new PriorityQueue<>((o1, o2) -> o2.v - o1.v);
		
		for (int bag : bags) {
			while (!jewels.isEmpty() && jewels.peek().w <= bag) pq.offer(jewels.poll());
			if (pq.isEmpty()) continue;
			ans += pq.poll().v;
		}
		System.out.println(ans);
	}

	static class J {
		int w;
		int v;

		J(int w, int v) {
			this.w = w;
			this.v = v;
		}
	}
}
