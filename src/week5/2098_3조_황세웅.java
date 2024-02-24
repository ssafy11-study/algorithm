import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[][] W, dp, prev;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int w = Integer.parseInt(st.nextToken());
				W[i][j] = w == 0 ? Integer.MAX_VALUE : w;
			}
		}
		
		dp = new int[1 << N][N];
		prev = new int[1 << N][N];
		
		for (int bit = 1; bit < 1 << N; bit++) {
			for (int i = 0; i < N; i++) {
				if ((bit & 1 << i) == 0) continue;
				for (int j = 0; j < N; j++) {
					if (i == j || (bit & 1 << j) == 0) continue;
					int prevBit = bit & ~(1 << i);
					int w = dp[prevBit][j] + W[j][i];
					if (dp[prevBit][j] == Integer.MAX_VALUE || W[j][i] == Integer.MAX_VALUE) w = Integer.MAX_VALUE;
					if (dp[bit][i] == 0 || w < dp[bit][i]) {
						dp[bit][i] = w;
						prev[bit][i] = prev[prevBit][j] == 0 ? j + 1 : prev[prevBit][j];
					}
				}
			}
		}
		
//		@Test
//		for (int bit = 1; bit < 1 << N; bit++) {
//			for (int i = 0; i < N; i++) {
//				if (dp[bit][i] != 0) System.out.printf("dp[%s][%d] = %d (%d)%n", Integer.toBinaryString(bit), i, dp[bit][i], prev[bit][i] - 1);
//				System.out.printf("dp[%s][%d] = %d%n", Integer.toBinaryString(bit), i, prev[bit][i]);
//			}
//		}
		
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int w = W[i][prev[(1 << N) - 1][i] - 1];
			if (w == Integer.MAX_VALUE) continue;
			ans = Math.min(ans, dp[(1 << N) - 1][i] + w);
		}
		System.out.println(ans);
	}
}

/*
dp[0001][0] = 0

dp[0010][1] = 0

dp[0011][0] = dp[0010][1] + w[1][0] = 5 (1 -> 0)
dp[0011][1] = dp[0001][0] + w[0][1] = 10 (0 -> 1)

dp[0100][2] = 0

dp[0101][0] = dp[0100][2] + w[2][0] = 6 (2 -> 0)
dp[0101][2] = dp[0001][0] + w[0][2] = 15 (0 -> 2)

dp[0110][1] = dp[0100][2] + w[2][1] = 13 (2 -> 1)
dp[0110][2] = dp[0010][1] + w[1][2] = 9 (1 -> 2)

dp[0111][0] = dp[0110][1] + w[1][0] = 13 + 5, dp[0110][2] + w[2][0] = 9 + 6 => 15 (1 -> 2 -> 0)
dp[0111][1] = dp[0101][0] + w[0][1] = 6 + 10, dp[0101][2] + w[2][1] = 15 + 13 => 16 (2 -> 0 -> 1)
dp[0111][2] = dp[0011][0] + w[0][2] = 5 + 15, dp[0011][1] + w[1][2] = 10 + 9 => 19 (0 -> 1 -> 2)

dp[1000][3] = 0

dp[1001][0] = dp[1000][3] + w[3][0] = 8
dp[1001][3] = dp[0001][0] + w[0][3] = 20

dp[1010][1] = dp[1000][3] + w[3][1] = 8
dp[1010][3] = dp[0010][1] + w[1][3] = 10

dp[1011][0] = dp[1010][1] + w[1][0] = 8 + 5, dp[1010][3] + w[3][0] = 10 + 8 => 13
dp[1011][1] = dp[1001][0] + w[0][1] = 8 + 10, dp[1001][3] + w[3][1] = 20 + 8 => 18
dp[1011][3] = dp[0011][0] + w[0][3] = 5 + 20, dp[0011][1] + w[1][3] = 10 + 10 => 20

dp[1100][2] = dp[1000][3] + w[3][2] = 9
dp[1100][3] = dp[0100][2] + w[2][3] = 12

dp[1101][0] = dp[1100][2] + w[2][0] = 9 + 6, dp[1100][3] + w[3][0] = 12 + 8 => 15
dp[1101][2] = dp[1001][0] + w[0][2] = 8 + 15, dp[1001][3] + w[3][2] = 20 + 9 => 23
dp[1101][3] = dp[0101][0] + w[0][3] = 6 + 20, dp[0101][2] + w[2][3] = 15 + 12 => 26

dp[1110][1] = dp[1100][2] + w[2][1] = 9 + 13, dp[1100][3] + w[3][1] = 12 + 8 => 20
dp[1110][2] = dp[1010][1] + w[1][2] = 8 + 9, dp[1010][3] + w[3][2] = 10 + 9 => 17
dp[1110][3] = dp[0110][1] + w[1][3] = 13 + 10, dp[0110][2] + w[2][3] = 9 + 12 => 21

dp[1111][0] = dp[1110][1] + w[1][0] = 20 + 5, dp[1110][2] + w[2][0] = 17 + 6, dp[1110][3] + w[3][0] = 21 + 8 => 23
dp[1111][1] = dp[1101][0] + w[0][1] = 15 + 10, dp[1101][2] + w[2][1] = 23 + 13, dp[1101][3] + w[3][1] = 26 + 8 => 25
dp[1111][2] = dp[1011][0] + w[0][2] = 13 + 15, dp[1011][1] + w[1][2] = 18 + 9, dp[1011][3] + w[3][2] = 20 + 9 => 27
dp[1111][3] = dp[0111][0] + w[0][3] = 15 + 20, dp[0111][1] + w[1][3] = 16 + 10, dp[0111][2] + w[2][3] = 19 + 12 => 26
*/