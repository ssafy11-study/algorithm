import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, D;
	static List<Integer>[] parents;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		parents = new List[N + 1];
		for (int i = 0; i < N + 1; i++) {
			parents[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			parents[Integer.parseInt(st.nextToken())].add(i);
		}
		
		int ans = 0;
		for (int i = 0; i < N + 1; i++) {
			int tmp = parents[i].size();
			while (tmp > D) {
				ans += tmp / D;
				tmp = tmp / D + tmp % D;
			}
		}
		System.out.println(ans);
	}
}
