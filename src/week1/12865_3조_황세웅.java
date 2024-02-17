package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution12865 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][k + 1];
        int[] weights = new int[n + 1];
        int[] values = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n + 1; i++) {
            for (int weight = 1; weight < k + 1; weight++) {
                dp[i][weight] = dp[i - 1][weight];
                if (weight >= weights[i]) {
                    dp[i][weight] = Math.max(dp[i][weight], dp[i - 1][weight - weights[i]] + values[i]);
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
