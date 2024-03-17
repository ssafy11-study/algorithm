package SSAFY.study.week8.t24449;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int R, C, answer;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static Deque<int[]> queue = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visited = new boolean[R][C];
        String s;
        for (int i = 0; i < R; i++) {
            s = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = s.charAt(j);
                if(c == '.') map[i][j] = 0;
                else map[i][j] = 1;
            }
        }
        queue.add(new int[]{0, 0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == R - 1 && cur[1] == C - 1) {
                answer = cur[2];
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(nr < 0 || nr == R || nc < 0 || nc == C || map[nr][nc] == map[cur[0]][cur[1]] || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc, cur[2] + 1});
            }
        }
        System.out.println(answer == 0 ? -1 : answer);
        br.close();
    }

}
