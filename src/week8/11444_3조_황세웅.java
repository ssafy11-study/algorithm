import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static long N;
	static long[][] d = {{1, 1}, {1, 0}};
	static final int PRIME = 1_000_000_007;
	
	public static void main(String[] args) throws IOException {
		N = Long.parseLong(br.readLine());
		if (N == 1) System.out.println(1);
		else System.out.println(pow(d, N - 1)[0][0]);
	}
	
	static long[][] pow(long[][] m, long e) {	
		if (e == 1) return m;
		long[][] res = pow(m, e / 2);
		if (e % 2 == 0) return times(res, res);
		return times(times(res, res), m);
	}
	
	static long[][] times(long[][] m1, long[][] m2) {
		long[][] res = new long[m1.length][m2[0].length];
		for (int r = 0; r < m1.length; r++) {
			for (int c = 0; c < m2[0].length; c++) {
				for (int i = 0; i < m2.length; i++) {
					res[r][c] += (m1[r][i] * m2[i][c]) % PRIME;
				}
				res[r][c] %= PRIME;
			}
		}
		return res;
	}
}