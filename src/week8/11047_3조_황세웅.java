import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, K, ans;
	static int[] cost;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		cost = new int[N];
		for (int i = N - 1; i >= 0; i--) {
			cost[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < N; i++) {
			int div = K / cost[i];
			K -= cost[i] * div;
			ans += div;
		}
		System.out.println(ans);
	}
}