import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T, N;
	static int[][] seq, dp;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			seq = new int[2][N + 1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < N + 1; i++) {
				seq[0][i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < N + 1; i++) {
				seq[1][i] = Integer.parseInt(st.nextToken());
			}
			
			dp = new int[N + 1][3];
			for (int i = 1; i < N + 1; i++) {
				int p1 = Math.max(dp[i - 1][0], dp[i - 1][2]);
				int p2 = Math.max(dp[i - 1][0], dp[i - 1][1]);
				dp[i][0] = Math.max(p1, p2);
				dp[i][1] = p1 + seq[0][i];
				dp[i][2] = p2 + seq[1][i];
			}
			
			int ans = 0;
			for (int i = 0; i < 3; i++) {
				ans = Math.max(ans, dp[N][i]);
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
	}
}