package SSAFY.study.week5.t2098;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] w;
    static int[][] dp;
    static final int INF = 987_654_321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        w = new int[N][N];
        dp = new int[N][(1 << N)]; // 현재위치, 방문상태
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        int answer = tsp(0, (1 << 0));

        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        System.out.println(answer);
        br.close();
    }

    public static int tsp(int here, int check) {
        if (check == (1 << N) - 1) {
            return w[here][0] == 0 ? INF : w[here][0];
        }
        if(dp[here][check] != -1) return dp[here][check];
        dp[here][check] = INF;
        for (int i = 1; i < N; i++) {
            if((check &(1<<i)) != 0) continue;
            int new_cost = w[here][i] + tsp(i, check | (1 << i));
            dp[here][check] = Math.min(dp[here][check], new_cost);
        }
        return dp[here][check];
    }
}
