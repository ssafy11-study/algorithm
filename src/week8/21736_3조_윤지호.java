import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[] start = new int[2];

		map = new char[N][];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'I') {
					start[0] = i;
					start[1] = j;
				}
			}
		}

		bfs(start[0], start[1]);
		System.out.println(result == 0 ? "TT" : result);
	}

	static int result = 0;
	static boolean[][] visit;

	static void bfs(int y, int x) {
		visit = new boolean[N][M];
		Queue<int[]> queue = new ArrayDeque<>();

		visit[y][x] = true;
		queue.offer(new int[] { y, x });

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];

				if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] || map[ny][nx] == 'X') {
					continue;
				}
				visit[ny][nx] = true;
				queue.offer(new int[] { ny, nx });
				if (map[ny][nx] == 'P') {
					result++;
				}
			}
		}
	}
}