import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static PriorityQueue<M> pq = new PriorityQueue<>((o1, o2) -> o1.e == o2.e ? o1.s - o2.s : o1.e - o2.e);

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new M(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		int cnt = 0;
		int prev = -1;
		while (!pq.isEmpty()) {
			M curr = pq.poll();
			if (curr.s < prev) continue;
			prev = curr.e;
			cnt++;
		}
		System.out.println(cnt);
	}
	
	static class M {
		int s;
		int e;
		
		M (int s, int e) {
			this.s = s;
			this.e = e;
		}
	}
}