
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class _7576 {
    static class Tomato {
        int x, y;
        int counter;

        Tomato(int x, int y, int counter) {
            this.x = x;
            this.y = y;
            this.counter = counter;
        }
    }

    static int answer;
    static int[][] map;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        ArrayDeque<Tomato> arrayDeque = new ArrayDeque<>();
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    arrayDeque.add(new Tomato(i, j, 0));
                }
            }
        }

        while (!arrayDeque.isEmpty()) {
            Tomato tomato = arrayDeque.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                    int temp = tomato.counter + 1;
                    answer = temp;
                    map[nx][ny] = temp;
                    arrayDeque.add(new Tomato(nx, ny, temp));
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    answer = -1;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}