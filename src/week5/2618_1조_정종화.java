// Subject: Study of Algorithm with SSAFY
// ProblemNo: 2618
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
        int getDist(Pos p){
            return Math.abs(p.x - this.x) + Math.abs(p.y - this.y);
        }
    }
    
    static int dist(int p, int q, int idx){
        if(p == 0){
            if(idx == 0) return v[q].getDist(new Pos(0, 0));
            else return v[q].getDist(new Pos(N - 1, N - 1));
        }
        return v[q].getDist(v[p]);
    }
    
    static void check(int from1, int from2, int to1, int to2, int cost){
        if(dp[to1][to2] > dp[from1][from2] + cost){
            dp[to1][to2] = dp[from1][from2] + cost;
            par[to1][to2] = new Pos(from1, from2);
        }
    }
    
    static final int MX = 1_000_000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, W, x, y, dp[][];
    static Pos v[], par[][];
    static ArrayDeque<Integer> stack = new ArrayDeque();
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());
        v = new Pos[W + 1]; par = new Pos[W + 1][W + 1];
        dp = new int[W + 1][W + 1];
        for(int i = 1; i <= W; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()); x--;
            y = Integer.parseInt(st.nextToken()); y--;
            v[i] = new Pos(x, y);
        }
        for(int i = 0; i <= W; i++) for(int j = 0; j <= W; j++) dp[i][j] = MX;
        dp[0][0] = 0;
        
        for(int i = 1; i <= W; i++){
            for(int j = 0; j < i; j++){
                if(dp[i - 1][j] != MX) {
                    check(i - 1, j, i - 1, i, dist(j, i, 1)); //dp[i - 1][i] = Math.min(dp[i - 1][i], dp[i - 1][j] + dist(j, i, 1));
                    check(i - 1, j, i, j, dist(i - 1, i, 0)); //dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dist(i - 1, i, 0));
                }
                if(dp[j][i - 1] != MX) {
                    check(j, i - 1, i, i - 1, dist(j, i, 0)); //dp[i][i - 1] = Math.min(dp[i][i - 1], dp[j][i - 1] + dist(j, i, 0));
                    check(j, i - 1, j, i, dist(i - 1, i, 1)); //dp[j][i] = Math.min(dp[j][i], dp[j][i - 1] + dist(i - 1, i, 1));
                }
            }
        }
        Pos res = new Pos(0, W);
        
        for(int i = 0; i <= W; i++) {
            if(dp[res.x][res.y] > dp[W][i]) res = new Pos(W, i);
            if(dp[res.x][res.y] > dp[i][W]) res = new Pos(i, W);
        }
        System.out.println(dp[res.x][res.y]);
        for(;res.x + res.y > 0; res = par[res.x][res.y]) stack.push(res.x < res.y? 2 : 1);
        while(!stack.isEmpty()) System.out.println(stack.pop());
        
    }
}