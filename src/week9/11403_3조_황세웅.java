import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static boolean[][] dist;
    
    public static void main(String[] args) throws IOException {
    	N = Integer.parseInt(br.readLine());
    	
    	dist = new boolean[N][N];
    	for (int r = 0; r < N; r++) {
    		st = new StringTokenizer(br.readLine());
    		for (int c = 0; c < N; c++) {
    			if (st.nextToken().charAt(0) == '1') dist[r][c] = true;
    		}
    	}
    	
    	for (int waypoint = 0; waypoint < N; waypoint++) {
    		for (int start = 0; start < N; start++) {
    			for (int end = 0; end < N; end++) {
    				if (dist[start][end]) continue;
    				if (dist[start][waypoint] && dist[waypoint][end]) dist[start][end] = true;
    			}
    		}
    	}
    	
    	for (int r = 0; r < N; r++) {
    		for (int c = 0; c < N; c++) {
    			sb.append(dist[r][c] ? 1 : 0).append(" ");
    		}
    		sb.setCharAt(sb.length() - 1, '\n');
    	}
    	System.out.println(sb);
    }
};