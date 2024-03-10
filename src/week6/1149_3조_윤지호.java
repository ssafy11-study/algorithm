import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] inputs, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inputs = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            inputs[i][0] = R;
            inputs[i][1] = G;
            inputs[i][2] = B;
        }

        dp[0][0] = inputs[0][0];
        dp[0][1] = inputs[0][1];
        dp[0][2] = inputs[0][2];

        for (int i = 1; i < N; i++) {
            dp[i][0] = inputs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = inputs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = inputs[i][2] + Math.min(dp[i - 1][1], dp[i - 1][0]);
        }
        System.out.println(Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]));
    }
}