import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int R, C;
	static int[][] map;
	static boolean[][] visited;
	static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int tr = 0;
		int tc = 0;
		
		map = new int[R][C];
		visited = new boolean[R][C];
		
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 2) {
					tr = r;
					tc = c;
				}
			}
		}
		
		int[][] dist = new int[R][C];
		dist[tr][tc] = 0;
		visited[tr][tc] = true;
		
		Queue<Path> queue = new ArrayDeque<>();
		queue.offer(new Path(tr, tc, 0));
		
		while (!queue.isEmpty()) {
			Path curr = queue.poll();
			dist[curr.r][curr.c] = curr.w;
			for (int[] d : direction) {
				int nr = curr.r + d[0];
				int nc = curr.c + d[1];
				if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				if (map[nr][nc] == 0) continue;
				if (visited[nr][nc]) continue;
				visited[nr][nc] = true;
				queue.offer(new Path(nr, nc, curr.w + 1));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 2) sb.append(0).append(" ");
				else if (map[r][c] == 0) sb.append(0).append(" ");
				else if (dist[r][c] == 0) sb.append(-1).append(" ");
				else sb.append(dist[r][c]).append(" ");
			}
			sb.setCharAt(sb.length() - 1, '\n');
		}
		System.out.println(sb);
	}
	
	static class Path {
		int r;
		int c;
		int w;
		
		Path(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}
	}
}