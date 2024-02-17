// Subject: Study of Algorithm with SSAFY
// ProblemNo: 2533
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {

	static final int MX = 10000;
	static final int BOUND = 10000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
	static int N, x, y, dp[][];
	static ArrayList<Integer>[] gph;
    static Deque<Integer> stack;

    static void dfs(int now, int parent){
        dp[1][now] = 1;
        dp[0][now] = 0;
        for(int tar : gph[now]){
            if(tar == parent) continue;
            dfs(tar, now);
            dp[0][now] += dp[1][tar];
            dp[1][now] += Math.min(dp[1][tar], dp[0][tar]);
        }
    }
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        
        gph = new ArrayList[N];
        dp = new int[2][N];
        
        for(int i = 0; i < N; i++) gph[i] = new ArrayList();
        
        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()); x--;
            y = Integer.parseInt(st.nextToken()); y--;
            gph[x].add(y);
            gph[y].add(x);
        }
        dfs(0, -1);
        System.out.println(Math.min(dp[0][0], dp[1][0]));
        
        
    }
}