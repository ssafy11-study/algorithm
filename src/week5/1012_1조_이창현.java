import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 이창현
	static int T, M, N, K, X, Y, result;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = { 0, 0, -1, 1};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visited = new boolean[N][M];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				X = Integer.parseInt(st.nextToken());
				Y = Integer.parseInt(st.nextToken());
				map[Y][X] = 1;
			}
			
			result = 0;
			// 풀이
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(visited[i][j] || map[i][j] == 0) continue;
					
					dfs(i, j);
					result++;
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
		
	}
	
	static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || map[nr][nc] == 0) continue;
			
			dfs(nr, nc);
		}
	}

}
