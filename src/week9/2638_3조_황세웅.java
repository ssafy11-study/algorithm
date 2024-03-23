import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int R, C, cnt, ans;
    static int[][] map;
    static boolean[][] visited;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == 1) cnt++;
            }
        }

        while (cnt > 0) {
            visited = new boolean[R][C];
            spread(0, 0);
            visited = new boolean[R][C];
            melt(0, 0);
            ans++;
        }
        System.out.println(ans);
    }

    static void spread(int r, int c) {
        if (visited[r][c]) return;
        visited[r][c] = true;
        map[r][c] = 2;

        for (int[] d : direction) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            if (map[nr][nc] == 1) continue;
            spread(nr, nc);
        }
    }

    static void melt(int r, int c) {
        if (visited[r][c]) return;
        visited[r][c] = true;

        if (map[r][c] == 1) {
            int tc = 0;
            for (int[] dd : direction) if (map[r + dd[0]][c + dd[1]] == 2) tc++;
            if (tc >= 2) {
                map[r][c] = 0;
                cnt--;
            }
            return;
        }

        for (int[] d : direction) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            melt(nr, nc);
        }
    }
};
