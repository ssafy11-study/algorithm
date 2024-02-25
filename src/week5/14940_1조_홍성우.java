package 알고리즘_스터디._5주차.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class _1423940 {
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ArrayDeque<Node> arrayDeque = new ArrayDeque<>();
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    arrayDeque.add(new Node(i, j));
                    visited[i][j] = true;
                    map[i][j] = 0;

                }
            }
        }

        while (!arrayDeque.isEmpty()) {
            Node node = arrayDeque.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 1 && !visited[nx][ny]) {
                    map[nx][ny] = map[node.x][node.y] + 1;
                    visited[nx][ny] = true;

                    arrayDeque.add(new Node(nx, ny));
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 &&  !visited[i][j]){
                    map[i][j] = -1;
                }
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);


    }
}
