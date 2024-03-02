import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int[] coll;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        coll = new int[N+1];
        dp = new int[N+1][N+1];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int i = 0;
        coll[i++] = Integer.parseInt(st.nextToken());
        coll[i++] = Integer.parseInt(st.nextToken());

        int iter = N-1;
        while (iter-->0) {
            coll[i++] = Integer.parseInt(reader.readLine().split(" ")[1]);
        }

        System.out.println(cal(0, N));
    }

    static int cal(int from, int to) {
        // 초기 행렬일 경우
        if (to - from == 1) return 0;

        // 이미 계산한 경우
        if (dp[from][to] != 0) return dp[from][to];

        // 범위 내의 모든 가능한 조건에 대해 탐색
        int min = Integer.MAX_VALUE;
        for (int i = from + 1; i < to; ++i) {
            int cal = cal(from, i) + cal(i, to) + coll[from] * coll[to] * coll[i];
            min = Math.min(min, cal);
        }

        dp[from][to] = min;
        return min;
    }
}
