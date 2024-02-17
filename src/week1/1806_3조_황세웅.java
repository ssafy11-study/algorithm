package baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1806 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int left = 1;
        int right = 1;
        int ans = Integer.MAX_VALUE;

        int[] acc = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            acc[i] = acc[i - 1] + Integer.parseInt(st.nextToken());
        }

        while (left < n + 1) {
            int curr = acc[right] - acc[left - 1];

            if (curr < s && right++ == n) {
                break;
            }
            if (curr >= s) {
                ans = Math.min(ans, right - left + 1);
                left++;
            }

        }

        if (acc[n] < s) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }

    }
}
