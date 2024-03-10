import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,m;
	static int[][] map, res;
	static StringBuilder sb = new StringBuilder();
	static final int INF = (int) 1e9;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		res = new int[N+1][N+1];
		
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (map[a][b] == 0) {
				map[a][b] = c;
			} else {
				if (map[a][b] > c) {
					map[a][b] = c;
				}
			}
			
		}

		// dist array init
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if (i == j) res[i][j] = 0;
				else if (map[i][j] != 0) res[i][j] = map[i][j];
				else res[i][j] = INF;
			}
		}
		
		// update dist array
		
		for(int k=1;k<=N;k++) {
			// 중간지점 생성
			for (int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					res[i][j] = Math.min(res[i][j], res[i][k]+res[k][j]);
				}
			}
		}
		
		// print dist array
		for (int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				sb.append(res[i][j]==INF?0:res[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
