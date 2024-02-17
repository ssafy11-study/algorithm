package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1629 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(pow(a, b, c));
    }

    static int pow(int base, int exp, int mod) {
        if (exp < 0) {
            return 0;
        }
        if (exp == 1) {
            return base % mod;
        }
        if (exp % 2 == 0) {
            int powed = pow(base, exp / 2, mod);
            return (int) ((long) powed * powed % mod);
        }
        return (int) ((long) base * pow(base, exp - 1, mod) % mod);
    }
}
