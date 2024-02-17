// Subject: Study of Algorithm with SSAFY
// ProblemNo: 13460
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

	static final int MX = 10001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
	static Deque<Integer> q = new ArrayDeque<>();
	static int N, M, start, v[][], res, tar;
	static String s, visited[];
	static int pre_x[] = {0, 0, -1, 1};
	static int pre_y[] = {-1, 1, 0, 0};
	
	static class Marble{
	    int x, y;
	    Marble(int x, int y){
	        this.x = x;
	        this.y = y;
	    }
	    int move(int dx, int dy){
	        if(v[x + dx][y + dy] == 0){
	            this.x += dx; this.y += dy;
	            return move(dx, dy);
	        }
	        else return v[x + dx][y + dy];
	    }
	}
	
	static boolean test(int type, int rx, int ry, int bx, int by){
	    if(type == 0) return ry <= by;
	    if(type == 1) return ry >= by;
	    if(type == 2) return rx <= bx;
	    if(type == 3) return rx >= bx;
	    return false;
	}
	
    static void simulate(int type, int now, int rx, int ry, int bx, int by){
        int RED, BLUE;
        RED = BLUE = 0;
        Marble r = new Marble(rx, ry);
        Marble b = new Marble(bx, by);
        
        if(test(type, rx, ry, bx, by)){ //각 방위에 대응하는 구슬 움직임 우선순위 결정
            RED = r.move(pre_x[type], pre_y[type]);
            if(RED != 2) v[r.x][r.y] = 1;
            BLUE = b.move(pre_x[type], pre_y[type]);
            if(RED != 2) v[r.x][r.y] = 0;
        }
        else{
            BLUE = b.move(pre_x[type], pre_y[type]);
            if(BLUE != 2) v[b.x][b.y] = 1;
            RED = r.move(pre_x[type], pre_y[type]);
            if(BLUE != 2) v[b.x][b.y] = 0;
        }
        if(BLUE == 2) return;
        char target = "LRUD".charAt(type);
        if(RED == 2){
            visited[0] = visited[now] + target;
            res = visited[0].length();
        }
        else{
            int encode = (10 * r.x + r.y) * 100 + (10 * b.x + b.y);
            if(visited[encode] == null) {
                visited[encode] = visited[now] + target;
                q.addLast(encode);               
            }
        }
    }

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        v = new int[N][M];
        visited = new String[MX];
        for(int i = 0; i < N; i++){
            s = br.readLine();
            for(int j = 0; j < M; j++){
                if(s.charAt(j) == '#') v[i][j] = 1;
                if(s.charAt(j) == 'O') v[i][j] = 2;
                if(s.charAt(j) == 'R') start += (10 * i + j) * 100;
                if(s.charAt(j) == 'B') start += (10 * i + j);
            }
        }
        res = tar = 0;
        visited[start] = "";
        q.addLast(start);
        
        while(res == 0 && !q.isEmpty()){
            int now = q.remove();
            int pos[] = {now / 1000, (now / 100) % 10, (now / 10) % 10, now % 10};
            for(int k = 0; k < 4; k++) simulate(k, now, pos[0], pos[1], pos[2], pos[3]);
        }
        
        if(res < 1 || res > 10) System.out.println(-1);
        else System.out.println(res);
    }
}
