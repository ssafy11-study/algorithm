// Subject: Study of Algorithm with SSAFY
// ProblemNo: 2098
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    
    static final int MX = 16_000_002;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, v[][], dp[][], res;

    public static void main(String[] args) throws Exception{
        
        N = Integer.parseInt(br.readLine());
        v = new int[N][N];
        dp = new int[(1 << N)][N];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) v[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < (1 << N); i++) for(int j = 0; j < N; j++) dp[i][j] = MX;
        dp[1][0] = 0;
        
        for(int i = 1; i < (1 << N); i++){
            for(int j = 0; j < N; j++){
                if(dp[i][j] == MX) continue;
                for(int k = 0; k < N; k++){
                    if(v[j][k] == 0 || ((i & (1 << k)) != 0)) continue;
                    dp[i | (1 << k)][k] = Math.min(dp[i | (1 << k)][k], dp[i][j] + v[j][k]);
                }
            }
        }
        
        res = MX;
        for(int j = 1; j < N; j++) if(v[j][0] != 0) res = Math.min(res, dp[(1 << N) - 1][j] + v[j][0]);
        System.out.print(res);
    }
}