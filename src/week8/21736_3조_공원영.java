package SSAFY.study.week8.t21736;

// backjoon 21736 헌내기는 친구가 필요해
// BFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer;
    static int[][] map;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static Deque<int[]> queue = new ArrayDeque<>();
    static int sr, sc;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                if(c == 'O') map[i][j] = 0;
                else if(c=='X') map[i][j] = -1;
                else if(c=='P') map[i][j] = 1;
                else if (c == 'I') {
                    sr = i;
                    sc = j;
                    map[i][j] = -1;
                }
            }
        }
        answer = 0;
        queue.add(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if(nr < 0 || nr == N || nc < 0 || nc == M || map[nr][nc] == -1) continue;
                if(map[nr][nc] == 1) answer++;
                queue.add(new int[]{nr, nc});
                map[nr][nc] = -1;
            }
        }
        System.out.println(answer==0 ? "TT" : answer);
        br.close();
    }
}
