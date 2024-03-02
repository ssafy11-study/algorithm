import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] next;
    static int[] counts;
    static int N, count;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-->0) {
            N = Integer.parseInt(reader.readLine());
            next = new int[N + 1];
            counts = new int[N + 1];
            count = 0;
            Arrays.fill(counts, -1);

            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int i = 1; i <= N; ++i) {
                next[i] = Integer.parseInt(st.nextToken());
            }

            int teams = 0;
            for (int i = 1; i <= N; ++i) {
                if (counts[i] == -1) {
                    teams += dfs(i, count);
                }
            }

            sb.append(N-teams).append('\n');
        }

        System.out.print(sb);
    }

    public static int dfs(int cur, int start) {
        if (counts[cur] == -1) {
            counts[cur] = count++;
            return dfs(next[cur], start);
        } else {
            if (counts[cur] < start) return 0;
            else {
                return count - counts[cur];
            }
        }
    }
}