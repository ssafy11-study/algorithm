import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static String S1, S2;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		S1 = br.readLine();
		S2 = br.readLine();
		dp = new int[S1.length() + 1][S2.length() + 1];
		
		int ans = 0;
		for (int i = 1; i < S1.length() + 1; i++) {
			for (int j = 1; j < S2.length() + 1; j++) {
				if (S1.charAt(i - 1) == S2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
				else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				ans = Math.max(ans, dp[i][j]);
			}
		}
		System.out.println(ans);
	}
}