package 알고리즘_스터디._2주차.class4;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2206 {
    static int[][] map;
    static boolean[][][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int M;
    static int answer = -1;

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        visited = new boolean[N][M][2];
        for (int i = 0; i < N; i++) {
            String line = bf.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<Tank> tankQueue = new LinkedList<>();
        tankQueue.add(new Tank(0, 0, 1, true));
        visited[0][0][1] = true;

        while (!tankQueue.isEmpty()) {
            Tank tank = tankQueue.poll();
            int cur_x = tank.x;
            int cur_y = tank.y;

            if (cur_x == N -1 && cur_y == M -1) {
                answer = tank.distance;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];

                // 벽 부순 상태에 따른 검사
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny][tank.ammo ? 1 : 0]) {
                    continue;
                }

                if (map[nx][ny] == 1 && tank.ammo) {
                    visited[nx][ny][1] = true;
                    tankQueue.add(new Tank(nx, ny, tank.distance + 1, false));
                } else if (map[nx][ny] == 0) {
                    visited[nx][ny][tank.ammo ? 1 : 0] = true;
                    tankQueue.add(new Tank(nx, ny, tank.distance + 1, tank.ammo));
                }
            }
        }
        System.out.println(answer);

    }

    static class Tank {
        int x;
        int y;
        int distance;
        boolean ammo;

        public Tank(int x, int y, int distance, boolean ammo) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.ammo = ammo;
        }
    }
}