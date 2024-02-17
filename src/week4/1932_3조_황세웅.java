import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < i + 1; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken()) + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
			}
		}
		
		int ans = 0;
		for (int i = 0; i < n + 1; i++) {
			ans = Math.max(ans, dp[n][i]);
		}
		System.out.println(ans);
	}
}
