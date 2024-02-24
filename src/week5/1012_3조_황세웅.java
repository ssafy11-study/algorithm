import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int T, C, R, K;
	static boolean[][] map, visited;
	static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new boolean[R][C];
			visited = new boolean[R][C];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = true;
			}
			
			int cnt = 0;
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (visited[r][c] || !map[r][c]) continue;
					dfs(r, c);
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int r, int c) {
		if (visited[r][c]) return;
		visited[r][c] = true;
		for (int[] d : direction) {
			int nr = r + d[0];
			int nc = c + d[1];
			if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
			if (map[nr][nc]) dfs(nr, nc);
		}
	}
}