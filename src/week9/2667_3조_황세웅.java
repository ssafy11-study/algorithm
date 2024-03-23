import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, ans, cnt;
    static PriorityQueue<Integer> ans2;
    static boolean[][] map, visited;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public static void main(String[] args) throws IOException {
    	N = Integer.parseInt(br.readLine());
    	
    	map = new boolean[N][N];
    	for (int r = 0; r < N; r++) {
    		String line = br.readLine();
    		for (int c = 0; c < N; c++) {
    			if (line.charAt(c) == '1') map[r][c] = true;
    		}
    	}
    	
    	ans2 = new PriorityQueue<>();
    	visited = new boolean[N][N];
    	for (int r = 0; r < N; r++) {
    		for (int c = 0; c < N; c++) {
    			if (visited[r][c]) continue;
    			if (!map[r][c]) continue;
    			ans++;
    			cnt = 0;
    			dfs(r, c);
    			ans2.add(cnt);
    		}
    	}
    	
    	sb.append(ans).append("\n");
    	while (!ans2.isEmpty()) sb.append(ans2.poll()).append("\n");
    	System.out.println(sb);
    }
    
    static void dfs(int r, int c) {
    	if (visited[r][c]) return;
    	visited[r][c] = true;
    	cnt++;
    	for (int[] d : direction) {
    		int nr = r + d[0];
    		int nc = c + d[1];
    		if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
    		if (!map[nr][nc]) continue;
    		dfs(nr, nc);
    	}
    }
};