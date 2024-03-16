import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int R, C, ans;
	static int[][] map;
	static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static boolean[][] visited;
	static int sr, sc;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		for (int r = 0; r < R; r++) {
			String s = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = s.charAt(c);
				if (map[r][c] == 'I') {
					sr = r;
					sc = c;
				}
			}
		}
		
		visited = new boolean[R][C];
		dfs(sr, sc);
		System.out.println(ans > 0 ? ans : "TT");
	}
	
	static void dfs(int r, int c) {
		if (visited[r][c]) return;
		visited[r][c] = true;
		if (map[r][c] == 'P') ans++;
		
		for (int[] d : direction) {
			int nr = r + d[0];
			int nc = c + d[1];
			if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
			if (map[nr][nc] == 'X') continue;
			dfs(nr, nc);
		}
	}
}