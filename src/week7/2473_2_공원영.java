package SSAFY.study.week7.t2473;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final long INF = 3_000_100_000L;
    static int N, left, right;
    static long answer;
    static long[] src;
    static long[] tgt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        src = new long[N];
        tgt = new long[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            src[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(src);
        answer = INF;
        for (int i = 0; i < N-2; i++) { // 하나 고정
            left = i+1;
            right = N - 1;
            long tmp = INF;
            int i1, i2, i3;
            i1 = i2 = i3 = 0;
            while (left < right) {
                // i번째 값을 고정하고 나머지 두개를 선택했을 때, 그 합이 0에 가장 가까운 경우를 저장.
                if (Math.abs(tmp) > Math.abs(src[i] + src[left] + src[right])) {
                    tmp = src[i] + src[left] + src[right];
                    i1 = i;
                    i2 = left;
                    i3 = right;
                }
                // 투포인터 이동 : -1 * i번째값에 가장 가깝도록 이동해야 한다.
                if(-1 * src[i] > src[left] + src[right] ) left++;
                else right--;
            }
            if (Math.abs(answer) > Math.abs(src[i1] + src[i2] + src[i3])) {
                answer = src[i1] + src[i2] + src[i3];
                tgt[0] = src[i1];
                tgt[1] = src[i2];
                tgt[2] = src[i3];
            }
        }

        Arrays.sort(tgt);
        System.out.println(tgt[0] + " " + tgt[1] + " " + tgt[2]);

        br.close();

    }
}
