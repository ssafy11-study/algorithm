import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M;
	static int[][] map;
	static long acc;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 2][M + 2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				acc += min(i, j);
			}
		}
		System.out.println(acc);
	}
	
	static int min(int r, int c) {
		int min = Integer.MAX_VALUE;
		min = Math.min(min, map[r][c] - 1);
		min = Math.min(min, map[r - 1][c]);
		min = Math.min(min, map[r + 1][c]);
		min = Math.min(min, map[r][c - 1]);
		min = Math.min(min, map[r][c + 1]);
		return Math.max(0, min);
	}
}
