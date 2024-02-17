import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int white;
	static int blue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, N, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}

	static void dfs(int sx, int ex, int sy, int ey) {

		if (ey - sy == 1 || ex - sx == 1) {
			if (map[sy][sx] == 1) {
				blue++;
			} else {
				white++;
			}
			return;
		}

		int w = 0;
		int b = 0;
		int total = 0;
		for (int i = sy; i < ey; i++) {
			for (int j = sx; j < ex; j++) {
				total++;
				if (map[i][j] == 1)
					b++;
				else
					w++;
			}
		}
		if (w == total) {
			white++;
			return;
		}
		else if (b == total) {
			blue++;
			return;
		}

		int xMid = (sx + ex) / 2;
		int yMid = (sy + ey) / 2;
		dfs(sx, xMid, sy, yMid);
		dfs(xMid, ex, sy, yMid);
		dfs(sx, xMid, yMid, ey);
		dfs(xMid, ex, yMid, ey);


	}
}
