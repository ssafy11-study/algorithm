import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans, total;
    static int[][] map;
    static Queue<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    total++;
                }
            }
        }

        ans = 0;
        while (total > 0) {
            bfs();
            total -= meltCheese();
            ans++;
        }

        System.out.println(ans);
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][M];
        queue.offer(new int[]{0, 0});
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx]) {
                    continue;
                }

                if (map[ny][nx] == 0) {
                    queue.offer(new int[]{ny, nx});
                    visit[ny][nx] = true;
                } else {
                    map[ny][nx]++;
                }
            }
        }
    }

    static int meltCheese() {
        int melted = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] >= 3) {
                    map[i][j] = 0;
                    melted++;
                } else if (map[i][j] == 2) {
                    map[i][j] = 1;
                }
            }
        }
        return melted;
    }
}