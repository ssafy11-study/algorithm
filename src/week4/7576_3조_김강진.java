import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int m,n,days,res;
	static int[][] map;
	static boolean[][] visited;
	
	
	// 퍼지는 방향 l r u d
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static Queue<Node> q = new ArrayDeque<>();
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					q.offer(new Node(i,j));
				}
			}
		}
		
		if (q.isEmpty()) {
			System.out.println(-1);
			return;
		}
		
		bfs();
		
		// check 0
		for (int i =0; i <n;i++) {
			for (int j=0;j<m;j++) {
				if (map[i][j] == 0) {
					res = 0;
					break;
				}
			}
		}
		
		res--;
		System.out.println(res);
	}
	
	static void bfs() {
		while (!q.isEmpty()) {
			Node node = q.poll();
			visited[node.y][node.x] = true;
			
			if (res < map[node.y][node.x]) res = map[node.y][node.x];
			
			for(int d =0; d<4;d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
			
				if (ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] != 0 || visited[ny][nx]) continue;
				map[ny][nx] = map[node.y][node.x] + 1;
				visited[node.y][node.x] = true;
				q.offer(new Node(ny,nx));
			}
		}
	}
	
	static class Node{
		int y,x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
}
