package SSAFY.study.week7.t7579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 987_654_321;
    static int N, M, W, min;
    static int[] memory;
    static int[] cost;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        memory = new int[N + 1];
        cost = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }
        W = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            W += cost[i];
        }
        // 배낭 문제와 유사 (N : 아이템 수, M : 비워야 할 메모리 크기)
        // 메모리의 크기를 배낭의 크기로 생각하면 메모리 초과(1<=N<=100, 1 ≤ M ≤ 10,000,000)
        // 배낭의 크기 W와 대응하는 비용을 생각해봐야 한다. W : 모든 비용의 합.
        // 비워야할 메모리 크기 고정, 최소 비용 <=> 비용 고정, 비워야할 메모리 크기 최대
        dp = new int[N + 1][W + 1]; // dp[i][j] : i번째 앱까지 확인했을 때, j의 비용으로 얻을 수 있는 메모리의 최대 크기
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                if (j >= cost[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j - cost[i]] + memory[i], dp[i - 1][j]);
                }
                else dp[i][j] = dp[i - 1][j];
            }
        }
        for (int i = 0; i <= W; i++) {
            if (dp[N][i] >= M) {
                System.out.println(i);
                break;
            }
        }
//        System.out.println(Arrays.toString(dp[N]));
        br.close();

    }

}
