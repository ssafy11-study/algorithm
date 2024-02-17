import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());

		int ans = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			if (s > r) {
				ans += 3;
				continue;
			}
			pq.add(r - s);
		}

		while (!pq.isEmpty()) {
			int p = pq.poll();
			if (g >= p + 1) {
				ans += 3;
				g -= p + 1;
			} else if (g >= p) {
				ans += 1;
				g -= p;
			}
		}
		System.out.println(ans);
	}
}
