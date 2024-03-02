package 알고리즘_스터디._6주차.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1149 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] dp = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            dp[i][0] = Integer.parseInt(st.nextToken()); // R
            dp[i][1] = Integer.parseInt(st.nextToken()); // G
            dp[i][2] = Integer.parseInt(st.nextToken()); // B
        }

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + dp[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + dp[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + dp[i][2];
        }
        System.out.println(Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]));
    }
}
