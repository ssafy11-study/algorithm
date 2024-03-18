import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static char[][]  map;
    static boolean[][]  visited;

    static int startX, startY;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = bf.readLine();
            for (int j = 0; j < M; j++) {
                char temp = line.charAt(j);
                map[i][j] = temp;
                if (temp == 'I') {
                    startX = j;
                    startY = i;
                }
            }
        }
        dfs(startX, startY);
        if (answer != 0) {
            System.out.println(answer);

        } else {
            System.out.println("TT");

        }
    }

    static void dfs(int x, int y) {

        if (map[y][x] == 'X') {
            return;
        }
        visited[y][x] = true;
        if (map[y][x] == 'P') {
            answer++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[ny][nx] && (map[ny][nx] == 'O'
                    || map[ny][nx] == 'P')) {
                dfs(nx, ny);
            }
        }
    }
}