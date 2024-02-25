// Subject: Study of Algorithm with SSAFY
// ProblemNo: 14940
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static class Pos{
        int x, y;
        Pos(int ...a){
            this.x = a[0]; this.y = a[1];
        }
    }
    static boolean inRange(int x, int y) { return x >= 0 && x < n && y >= 0 && y < m; }

    static final int MX = 100001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m, v[][], vtd[][];
    static ArrayDeque<Pos> q = new ArrayDeque();
    static Pos S;
    
    public static void main(String[] args) throws Exception{
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        vtd = new int[n][m];
        v = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                v[i][j] = Integer.parseInt(st.nextToken());
                if(v[i][j] == 2) { v[i][j]--; S = new Pos(i, j); }
            }
        }
        vtd[S.x][S.y] = 1; q.offer(S);
        while(!q.isEmpty()){
            Pos now = q.poll();
            for(int i = 0; i < 4; i++){
                int dx = now.x + "2011".charAt(i) - '1';
                int dy = now.y + "1120".charAt(i) - '1';
                if(inRange(dx, dy) && vtd[dx][dy] == 0 && v[dx][dy] > 0){
                    vtd[dx][dy] = vtd[now.x][now.y] + 1;
                    q.offer(new Pos(dx, dy));
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) System.out.print(vtd[i][j] - v[i][j] + " ");
            System.out.println();
        }
    }
}