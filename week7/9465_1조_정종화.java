// Subject: Study of Algorithm with SSAFY
// ProblemNo: B9465
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {


    static final int MX = 999999;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T, N, v[][], dp[][];
    static boolean isBroken[];
   
    public static void main(String[] args) throws Exception{
        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            N = Integer.parseInt(br.readLine());
            v = new int[N][2];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) v[i][0] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) v[i][1] = Integer.parseInt(st.nextToken());
            
            dp = new int[N + 1][3];
            //0->1, 2 / 1->0, 2 /2->0, 1, 2
            for(int i = 0; i < N; i++){
                for(int j = 0; j < 3; j++){
                    for(int k = 0; k < 3; k++){
                        if(j < 2 && j == k) continue;
                        dp[i + 1][k] = Math.max(dp[i + 1][k], dp[i][j] + (k != 2? v[i][k] : 0));
                    }
                }
            }
            sb.append(Math.max(Math.max(dp[N][0], dp[N][1]), dp[N][2])).append('\n');
        }
        System.out.print(sb);
        
    }
}