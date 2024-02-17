import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[][] map;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int n, m;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];
		Queue<Pos> queue = new ArrayDeque<>();
		
		int total = 0;
		int acc = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				switch (map[i][j]) {
				case 1:
					total++;
					queue.offer(new Pos(i, j, 0));
					visited[i][j] = true;
					break;
				case -1:
					visited[i][j] = true;
					break;
				case 0:
					total++;
					break;
				}
			}
		}
		
		int ans = -1;
		while (!queue.isEmpty()) {
			Pos curr = queue.poll();
			
			if (++acc == total) {
				ans = curr.depth;
				break;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dy[d];
				int nc = curr.c + dx[d];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
					continue;
				}
				if (visited[nr][nc]) {
					continue;
				}
				visited[nr][nc] = true;
				queue.add(new Pos(nr, nc, curr.depth + 1));
			}
		}
		System.out.println(ans);
	}
	
	static class Pos {
		int r;
		int c;
		int depth;
		
		Pos (int r, int c, int depth) {
			this.r = r;
			this.c = c;
			this.depth = depth;
		}
	}
}
