package 알고리즘_스터디._6주차.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _11726 {
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10_007;
        }
        System.out.println(dp[n]);

    }
}