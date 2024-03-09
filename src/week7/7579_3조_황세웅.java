import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M;
	static int[] used, cost;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		used = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			used[i] = Integer.parseInt(st.nextToken());
		}
		
		cost = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N + 1][10001];
		for (int i = 1; i < N + 1; i++) {
			for (int c = 0; c < 10001; c++) {
				dp[i][c] = dp[i - 1][c];
				if (cost[i] <= c) dp[i][c] = Math.max(dp[i - 1][c], dp[i - 1][c - cost[i]] + used[i]);
			}
		}
		
		for (int c = 0; c < 10001; c++) {
			if (dp[N][c] >= M) {
				System.out.println(c);
				break;
			}
		}
	}
}