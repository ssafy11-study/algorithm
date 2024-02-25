package SSAFY.study.week5.t1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/*
    baekjoon 1012 유기농 배추
    Flood Fill
    BFS/DFS
 */
public class Main {
    static int N, M, K, ans;
    static int[][] map;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // col
            N = Integer.parseInt(st.nextToken()); // row
            map = new int[N][M];
            K = Integer.parseInt(st.nextToken()); // # of bugs
            int y, x;
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }
            ans = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
//                        bfs(i, j);
                        dfs(i, j);
                        ans++;
                    }
                }
            }
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
        br.close();
    }

    public static void dfs(int y, int x) {
        map[y][x] = 0;
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(ny < 0 || ny == N || nx < 0 || nx == M || map[ny][nx] == 0) continue;
            dfs(ny, nx);
        }
    }

    public static void bfs(int y, int x) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y, x});
        map[y][x] = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int ny = cur[0] + dy[d];
                int nx = cur[1] + dx[d];
                if(ny < 0 || ny == N || nx < 0 || nx == M || map[ny][nx] == 0) continue;
                map[ny][nx] = 0;
                queue.add(new int[]{ny, nx});
            }
        }
    }
}
