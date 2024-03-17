package SSAFY.study.week8.t21396;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T, n, x;
    static long answer;
    static int[] v;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            v = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                v[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(v);
            answer = 0;
            for (int i = 0; i < n - 1; i++) {
                long k = v[i] ^ x;
                int l = lb(k, i + 1, n);
                int r = rb(k, i + 1, n);
                if(l >= r || v[l] != k) continue;
                answer += (r - l);
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static int lb(long x, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if(v[mid] >= x) right = mid;
            else left = mid + 1;
        }
        return right;
    }
    static int rb(long x, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if(v[mid] <= x) left = mid+1;
            else right = mid;
        }
        return right;
    }
}
