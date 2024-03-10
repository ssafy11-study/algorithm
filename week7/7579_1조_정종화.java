// Subject: Study of Algorithm with SSAFY
// ProblemNo: B7579
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {

    static boolean check(int K){
        int dp[][] = new int[N + 1][K + 1];
        for(int i = 0; i < N; i++){
            for(int j = 0; j <= K; j++){
                if(j + cost[i] <= K)
                dp[i + 1][j + cost[i]] = Math.max(dp[i + 1][j + cost[i]], dp[i][j] + mem[i]);
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
            }
        }
        return (dp[N][K] >= M);
    }

    static final int MX = 999999;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int mem[], cost[], N, M, res;
    
    public static void main(String[] args) throws Exception{
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mem = new int[N]; cost = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) mem[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) cost[i] = Integer.parseInt(st.nextToken());
        
        int l, r, mid;
        l = 0; r = 10001;
        while(l <= r){
            mid = (l + r) / 2;
            if(check(mid)){
                res = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }
        System.out.print(res);
    }
}