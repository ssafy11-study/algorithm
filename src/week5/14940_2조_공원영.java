package SSAFY.study.week5.t14940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/*
    baekjoon 14940 쉬운 최단거리
    지도가 주어지면 모든 지점에 대해서 목표지점까지의 거리를 구하여라.
    문제를 쉽게 만들기 위해 오직 가로와 세로로만 움직일 수 있다고 하자.
 */
public class Main {
    static int R, C;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int sr, sc;
    static int[][] ans;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        ans = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    sr = i;
                    sc = j;
                }
            }
        }
//        for (int i = 0; i < R; i++) {
//            Arrays.fill(ans[i], -1);
//        }
        bfs(sr, sc);
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int val;
                if(ans[i][j] == 0){
                    if(map[i][j] == 0 || (i==sr && j==sc)) val = 0;
                    else val = -1;
                } else val = ans[i][j];
                sb.append(val).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
        br.close();
    }

    public static void bfs(int r, int c) {
        visited = new boolean[R][C];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r, c});
        ans[r][c] = 0;
        visited[r][c]=true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if(nr < 0 || nr == R || nc < 0 || nc == C || visited[nr][nc] || map[nr][nc] == 0) continue;
                visited[nr][nc] = true;
                ans[nr][nc] = ans[cur[0]][cur[1]]+1;
                queue.add(new int[]{nr, nc});
            }
        }
    }
}
