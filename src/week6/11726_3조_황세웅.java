import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int[] dp;
	static int[][] unit = {{1, 1}, {1, 0}};
	static int[][] init = {{2}, {1}};
	static final int PRIME = 10_007;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		if (N == 1) System.out.println(1);
		else if (N == 2) System.out.println(2);
		else System.out.println(mul(pow(unit, N - 2), init)[0][0]);
	}
	
	static int[][] pow(int[][] base, int exp) {
		if (exp == 1) return base;
		int[][] powed = pow(base, exp / 2);
		if (exp % 2 == 0) return mul(powed, powed);
		return mul(mul(powed, powed), base);
	}
	
	static int[][] mul(int[][] v1, int[][] v2) {
		int R = v1.length;
		int C = v2[0].length;
		int T = v2.length;
		
		int[][] res = new int[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				for (int i = 0; i < T; i++) {
					res[r][c] += ((long)v1[r][i] * v2[i][c]) % PRIME;
				}
				res[r][c] %= PRIME;
			}
		}
		return res;
	}
}