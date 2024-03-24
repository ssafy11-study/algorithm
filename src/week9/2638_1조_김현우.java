import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int arr[][];
	static int[] dy = {-1,1,0,0}, dx = {0,0,-1,1};
	static int N, M, cheeze = 0, time = 0;
	static boolean visited[][];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int [N][M];
		visited = new boolean [N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1)cheeze++;
			}
		}
		while(cheeze != 0) {
			visited = new boolean[N][M];
			time++;
			bfs(0,0);
		}
		System.out.println(time);
	}
	
	static void bfs(int y , int x) {
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{0,0});
		visited[0][0] = true;
		while(!q.isEmpty()) {
			int tmp[] = q.poll();
			for(int i = 0; i < 4; i++) {
				int ny = tmp[0] + dy[i], nx = tmp[1] + dx[i];
				if(ny<0||nx<0||ny>=N||nx>=M) continue;
				if (visited[ny][nx] && arr[ny][nx] == 0)continue;
				if(arr[ny][nx] == 0) {
					q.offer(new int[] {ny,nx});
					visited[ny][nx] = true;
				}
				else {
					if(!visited[ny][nx])visited[ny][nx] = true;
					else {
						arr[ny][nx] = 0;
						cheeze--;
					}
				}
			}
		}
	}
}
