// Subject: Study of Algorithm with SSAFY
// ProblemNo: B11404
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {


    static final int MX = 999999;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T, N, M, x, y, d, gph[][];
   
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        gph = new int[N][N];
        for(int i = 0; i < N; i++)
        for(int j = 0; j < N; j++)
        if(i != j) gph[i][j] = 100_000_009;
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()); x--;
            y = Integer.parseInt(st.nextToken()); y--;
            d = Integer.parseInt(st.nextToken());
            gph[x][y] = Math.min(gph[x][y], d);
        }
        
        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    gph[i][j] = Math.min(gph[i][j], gph[i][k] + gph[k][j]);
                }
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++) sb.append(gph[i][j] == 100_000_009? 0 : gph[i][j]).append(' ');
            sb.append('\n');
        }
        System.out.print(sb);
        
    }
}