package SSAFY.study.week8.t9252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
    LCS2 baekjoon 9252
 */
public class Main {
    static char[] c1;
    static char[] c2;
    static int l1, l2;
    static int[][]dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        c1 = br.readLine().toCharArray();
        c2 = br.readLine().toCharArray();
        l1 = c1.length;
        l2 = c2.length;
        dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[l1][l2]);
//        for (int i = 0; i <= l1; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        int r=l1;
        int c=l2;
        char[] chArr = new char[dp[l1][l2]];
        int idx = dp[l1][l2] - 1;
        while (r != 0 && c != 0) {
            if (dp[r][c] != dp[r - 1][c] && dp[r][c] != dp[r][c - 1]) {
//                System.out.print(c1[r-1]);
                chArr[idx--] = c1[r - 1];
                r -= 1;
                c -= 1;
            }else{
                if (dp[r][c] == dp[r][c-1]) {
                    c -= 1;
                } else {
                    r -= 1;
                }
            }
        }
        for (int i = 0; i < chArr.length; i++) {
            System.out.print(chArr[i]);
        }
        br.close();
    }
}
