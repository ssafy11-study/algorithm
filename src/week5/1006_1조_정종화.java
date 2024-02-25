// Subject: Study of Algorithm with SSAFY
// ProblemNo: 1006
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    
    static final int MX = 1000000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T, N, W, u[], d[], dp[][][];
    
    public static void main(String[] args) throws Exception{
        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            u = new int[N]; d = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) u[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) d[i] = Integer.parseInt(st.nextToken());
            
            dp = new int[4][N + 2][3];
            for(int k = 0; k < 4; k++) {
                for(int i = 0; i < N + 2; i++) for(int j = 0; j < 3; j++) dp[k][i][j] = MX;
                dp[k][k / 3][k % 3] = 0;
            }
            
            for(int k = 0; k < 4; k++){
                for(int i = 0; i < N; i++){
                    if(dp[k][i][0] != MX){
                        dp[k][i][1] = Math.min(dp[k][i][1], dp[k][i][0] + 1);
                        dp[k][i][2] = Math.min(dp[k][i][2], dp[k][i][0] + 1);
                        if(u[i] + d[i] <= W) dp[k][i + 1][0] = Math.min(dp[k][i + 1][0], dp[k][i][0] + 1);
                        if(u[i] + u[(i + 1) % N] <= W && d[i] + d[(i + 1) % N] <= W) dp[k][i + 2][0] = Math.min(dp[k][i + 2][0], dp[k][i][0] + 2);
                    }
                    if(dp[k][i][1] != MX){
                        dp[k][i + 1][0] = Math.min(dp[k][i + 1][0], dp[k][i][1] + 1);
                        if(u[i] + u[(i + 1) % N] <= W) dp[k][i + 1][2] = Math.min(dp[k][i + 1][2], dp[k][i][1] + 1);
                    }
                    if(dp[k][i][2] != MX){
                        dp[k][i + 1][0] = Math.min(dp[k][i + 1][0], dp[k][i][2] + 1);
                        if(d[i] + d[(i + 1) % N] <= W) dp[k][i + 1][1] = Math.min(dp[k][i + 1][1], dp[k][i][2] + 1);
                    }
                }
            }
            ArrayList<Integer> result_list = new ArrayList();
            for(int k = 0; k < 4; k++) result_list.add(dp[k][N + k / 3][k % 3]);
            Collections.sort(result_list);
            sb.append(result_list.get(0)).append('\n');
        }
        System.out.print(sb);
    }
}