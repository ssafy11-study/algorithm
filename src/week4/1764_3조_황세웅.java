import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Set<String> set = new HashSet<>();
		PriorityQueue<String> pq = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}
		for (int i = 0; i < m; i++) {
			String name = br.readLine();
			if (set.contains(name)) {
				pq.add(name);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(pq.size()).append("\n");
		while (!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		System.out.println(sb);
	}
}
