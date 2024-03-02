import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static M[] seq;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N][N];
		seq = new M[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			seq[i] = new M(r, c);
			for (int j = 0; j < N; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
			dp[i][i] = 0;
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = i - 1; j >= 0; j--) {
				for (int k = j; k < i; k++) {
					int w = dp[j][k] + dp[k + 1][i] + seq[j].r * seq[k].c * seq[i].c;
					dp[j][i] = Math.min(dp[j][i], w);
				}
			}
		}
		System.out.println(dp[0][N - 1]);
	}
	
	static class M {
		int r;
		int c;
		
		M(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}