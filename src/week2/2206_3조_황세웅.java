import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static final int[][] DIRECTION = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    static int[][] graph;
    static boolean[][][] visited;
    static int n, m;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m][2];
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int ans = bfs();
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    static int bfs() {
        Queue<Path> queue = new LinkedList<>();
        queue.add(new Path(0, 0, 1, 0));

        while (!queue.isEmpty()) {
            Path curr = queue.poll();

            if (curr.row == n - 1 && curr.column == m - 1) {
                return curr.depth;
            }

            for (int[] d : DIRECTION) {
                int nextRow = curr.row + d[0];
                int nextColumn = curr.column + d[1];

                if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= m) {
                    continue;
                }

                if (curr.breakCnt == 0) {
                    if (visited[nextRow][nextColumn][0]) {
                        continue;
                    }
                    if (graph[nextRow][nextColumn] == 0) {
                        queue.add(new Path(nextRow, nextColumn, curr.depth + 1, 0));
                        visited[nextRow][nextColumn][0] = true;
                    } else {
                        queue.add(new Path(nextRow, nextColumn, curr.depth + 1, 1));
                        visited[nextRow][nextColumn][1] = true;
                    }
                } else {
                    if (visited[nextRow][nextColumn][1]) {
                        continue;
                    }
                    if (graph[nextRow][nextColumn] == 0) {
                        queue.add(new Path(nextRow, nextColumn, curr.depth + 1, 1));
                        visited[nextRow][nextColumn][1] = true;
                    }
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    static class Path {
        int row;
        int column;
        int depth;
        int breakCnt;

        public Path(int row, int column, int depth, int breakCnt) {
            this.row = row;
            this.column = column;
            this.depth = depth;
            this.breakCnt = breakCnt;
        }
    }
}
