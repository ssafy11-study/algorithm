package SSAFY.study.week7.t2473;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    static final long INF = 3_000_000_100L;
    static int N, left, right;
    static long answer, tmp;
    static long[] src;
    static long[] tgt;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        src = new long[N];
        tgt = new long[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            src[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(src);
        answer = INF;
        for (int i = 0; i < N - 2; i++) {
            left = i+1;
            right = N - 1;
            while (left < right) {
                tmp = src[i] + src[left] + src[right];
                if (answer > Math.abs(tmp)) {
                    answer = Math.abs(tmp);
                    tgt[0] = src[i];
                    tgt[1] = src[left];
                    tgt[2] = src[right];
                }
                if(tmp < 0 ) left++;
                else right--;
            }
        }
        sb.append(tgt[0]).append(" ").append(tgt[1]).append(" ").append(tgt[2]);
        System.out.println(sb);
        br.close();
    }
}
