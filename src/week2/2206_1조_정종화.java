// Subject: Study of Algorithm with SSAFY
// ProblemNo: 2206
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static class Info{
	    int s, x, y; //s for status
	    Info(int s, int x, int y){
	        this.s = s;
	        this.x = x;
	        this.y = y;
	    }
	}
	
	static final int MX = 10001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Deque<Info> queue = new ArrayDeque<>();
	static int N, M, map[][], visited[][][], res;
	
	static void init() throws Exception {
	    st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    map = new int[N][M];
	    visited = new int[2][N][M];
	    for(int i = 0; i < N; i++){
	        String s = br.readLine();
	        for(int j = 0; j < M; j++) if(s.charAt(j) == '1') map[i][j] = 1;
	    }
	}
	
	static boolean inRange(int x, int y) { return x >= 0 && x < N && y >= 0 && y < M; }
	
    public static void main(String[] args) throws Exception{
        init();
        queue.addLast(new Info(0, 0, 0));
        visited[0][0][0] = 1;
        while(!queue.isEmpty()){
            Info now = queue.removeFirst();
            for(int i = 0; i < 4; i++){
                int dx = now.x + "2011".charAt(i) - '1';
                int dy = now.y + "1120".charAt(i) - '1';
                // 0->0:0 , 0->1:1  1->0:1  1->1:Impossible
                if(inRange(dx, dy) && (now.s + map[dx][dy] < 2) && visited[now.s + map[dx][dy]][dx][dy] == 0){
                    visited[now.s + map[dx][dy]][dx][dy] = visited[now.s][now.x][now.y] + 1;
                    queue.addLast(new Info(now.s + map[dx][dy], dx, dy));
                }
            }
        }
        if(visited[0][N - 1][M - 1] == 0) visited[0][N - 1][M - 1] = 1000000000;
        if(visited[1][N - 1][M - 1] == 0) visited[1][N - 1][M - 1] = 1000000000;
        int res = Math.min(visited[0][N - 1][M - 1], visited[1][N - 1][M - 1]);
        if(res == 1000000000) res = -1;
        System.out.println(res);
    }
}
