import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, l, r;
    static long d;
    static int[] ans = {0, 0, 0};
    static int[] seq;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        seq = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(seq);

        d = Long.MAX_VALUE;
        for (int ll = 0; ll < N - 2; ll++) {
            twoPointer(ll);
        }
        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
    }

    static void twoPointer(int ll) {
        l = ll + 1;
        r = N - 1;

        while (l < r) {
            long v = (long)seq[ll] + seq[l] + seq[r];
            if (Math.abs(v) < d) {
                d = Math.min(d, Math.abs(v));
                ans = new int[] {seq[ll], seq[l], seq[r]};
            }
            if (v > 0) r--;
            else l++;
        }
    }
}
