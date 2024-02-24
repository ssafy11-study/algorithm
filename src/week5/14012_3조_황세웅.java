import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M;
	static int[] costs;
	static int[] pays;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		costs = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			costs[i] = Integer.parseInt(st.nextToken());
		}
		
		pays = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pays[i] = Integer.parseInt(st.nextToken());
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
		for (int i = 0; i < N; i++) {
			if (costs[i] < pays[i]) pq.offer(new int[]{costs[i], pays[i] - costs[i]});
		}
		
		long ans = M;
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			if (curr[0] > ans) break;
			ans += curr[1];
		}
		System.out.println(ans);
	}
}
