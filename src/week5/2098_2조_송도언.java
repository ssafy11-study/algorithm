import java.io.*;
import java.util.*;

public class Main {
    static int N, end;
    static int[][] graph, dp;
    static final int MAX = 16_000_001;

    static int search(int idx, int mask){

        if(mask == end){
            if(graph[idx][0] == 0) return MAX;
            return graph[idx][0];
        }

        if(dp[idx][mask] != -1) return dp[idx][mask];
        int ret = MAX;
        for (int i = 0; i < N; i++) {
            if((mask & 1 << i) != 0 || graph[idx][i] == 0) continue;
            ret = search(i, mask | 1 << i);
            if(ret == MAX) continue;
            if(dp[idx][mask] == -1) dp[idx][mask] = ret + graph[idx][i];
            else dp[idx][mask] = Math.min(dp[idx][mask], ret + graph[idx][i]);
        }
        if(dp[idx][mask] == -1) return dp[idx][mask] = MAX;
        return dp[idx][mask];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        end = (1 << N) - 1;
        StringTokenizer st;
        graph = new int[N][N];
        dp = new int[N][end + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int num = search(0, 1);
        System.out.println(num);
    }
}
