// Subject: Study of Algorithm with SSAFY
// ProblemNo: B7576
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static class Pos{
        int x, y;
        Pos(int ...a){
            this.x = a[0];
            this.y = a[1];
        }
    }

	static final int MX = 10001;
	static final int BOUND = 1000000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayDeque<Integer> dq = new ArrayDeque();
    static String s;
    static int M, N, v[][], vtd[][];
    static ArrayDeque<Pos> q = new ArrayDeque();
    
    static boolean inRange(int x, int y){ return x >= 0 && x < N && y >= 0 && y < M; }

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        v = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                v[i][j] = Integer.parseInt(st.nextToken());
                if(v[i][j] == 1) q.offer(new Pos(i, j));
            }
        }
        while(!q.isEmpty()){
            Pos now = q.poll();
            for(int i = 0; i < 4; i++){
                int dx = now.x + "2011".charAt(i) - '1';
                int dy = now.y + "1120".charAt(i) - '1';
                if(inRange(dx, dy) && v[dx][dy] == 0){
                    v[dx][dy] = v[now.x][now.y] + 1;
                    q.offer(new Pos(dx, dy));
                }
            }
        }
        boolean FLAG = true;
        int res = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                res = Math.max(res, v[i][j]);
                if(v[i][j] == 0) FLAG = false;
            }
        }
        if(!FLAG) res = 0;
        System.out.println(res - 1);
    }
}