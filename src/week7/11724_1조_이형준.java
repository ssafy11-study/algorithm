import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11724 {
	static boolean[][] adj;
	static boolean[] visit;
    public static void main(String[] args) throws Exception{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adj = new boolean[N + 1][N + 1];
        visit = new boolean[N + 1];
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int n1 = Integer.parseInt(st.nextToken());
        	int n2 = Integer.parseInt(st.nextToken());

            adj[n1][n2] = adj[n2][n1] = true;
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                dfs(i, N);
                ans++;
            }
        }

        System.out.println(ans);

    }

    static void dfs(int n, int N) {
        visit[n] = true;

        for (int i = 1; i <= N; i++) {
            if (!visit[i] && adj[i][n])
                dfs(i, N);
        }
    }
}