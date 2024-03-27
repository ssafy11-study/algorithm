import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static int N, count, dep;
	static int[][] map;
	static List<int[]> dList = new ArrayList<>();
	static boolean[][] visit;
	static List<Integer> ansList = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = input[j] - '0';
				if (map[i][j] == 1) {
					dList.add(new int[] { i, j });
				}
			}
		}

		for (int[] n : dList) {
			if (!visit[n[0]][n[1]]) {
				count++;
				dep = 0;
				dfs(n[0], n[1]);
				ansList.add(dep);
			}
		}
		sb.append(count).append("\n");

		Collections.sort(ansList);
		for (int n : ansList) {
			sb.append(n).append("\n");
		}
		System.out.println(sb);
	}

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static void dfs(int y, int x) {
		if (visit[y][x]) {
			return;
		}

		visit[y][x] = true;
		dep++;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] || map[ny][nx] == 0) {
				continue;
			}
			dfs(ny, nx);
		}
	}
}