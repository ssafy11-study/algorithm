import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int T,M,N,K,X,Y, map[][], ans;
	
	
	// delta U D L R
	static int[] dy = { -1 , 1, 0, 0};
	static int[] dx = { 0 , 0, -1, 1};
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			for (int k=0;k<K;k++) {
				st = new StringTokenizer(br.readLine());
				X = Integer.parseInt(st.nextToken());
				Y = Integer.parseInt(st.nextToken());
				
				map[Y][X] = 1;
			}
			
			ans = 0;
			
			for (int i=0;i<N;i++) {
				for (int j=0;j<M;j++) {
					if (map[i][j] == 1) {
						bfs(i,j);
						ans++;
					} else {
						map[i][j] = -1;
					}
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int y, int x) {
//		System.out.println("NEW BFS"+ans);
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(y,x));
		map[y][x] = -1;
		
		while (!q.isEmpty()) {
			Node temp = q.poll();
			
//			System.out.printf("y: %d, x: %d\n", temp.y, temp.x);
			
//			map[temp.y][temp.x] = -1;
			
			for (int d=0;d<4;d++) {
				int ny = temp.y + dy[d];
				int nx = temp.x + dx[d];
				
				if (ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] != 1) continue;
				q.offer(new Node(ny,nx));
				map[ny][nx] = -1;
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
