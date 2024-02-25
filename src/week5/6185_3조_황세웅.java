import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[] seq;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        seq = new int[M];
        for (int i = 0; i < M; i++) {
            seq[i] = Integer.parseInt(br.readLine()) - 1;
        }

        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int waypoint = 0; waypoint < N; waypoint++) {
            for (int start = 0; start < N; start++) {
                for (int end = 0; end < N; end++) {
                    int newPath = dist[start][waypoint] + dist[waypoint][end];
                    dist[start][end] = Math.min(dist[start][end], newPath < 0 ? Integer.MAX_VALUE : newPath);
                }
            }
        }

        int ans = 0;
        for (int i = 1; i < M; i++) {
            ans += dist[seq[i - 1]][seq[i]];
        }
        System.out.println(ans);
    }
}
