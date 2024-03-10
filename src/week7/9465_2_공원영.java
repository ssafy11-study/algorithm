package SSAFY.study.week7.t9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T, N;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            dp = new int[2][N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                dp[0][i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                dp[1][i] = Integer.parseInt(st.nextToken());
            }
//            System.out.println(Arrays.toString(dp[0]));
//            System.out.println(Arrays.toString(dp[1]));

            int m1, m2;
            for (int i = 2; i <= N; i++) {
                m1 = Math.max(dp[0][i - 2], dp[1][i - 1]);
                m1 = Math.max(m1, dp[1][i - 2]);
                dp[0][i] += m1;
                m2 = Math.max(dp[1][i - 2], dp[0][i - 1]);
                m2 = Math.max(m2, dp[0][i - 2]);
                dp[1][i] += m2;
            }
            sb.append(Math.max(dp[0][N], dp[1][N])).append("\n");

        }
        System.out.println(sb);
        br.close();
    }
}
