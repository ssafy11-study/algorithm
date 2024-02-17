import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] ds = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
    static Queue<Memory> que = new LinkedList<>();
    static char[][] board;
    static boolean[][][][] visited;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        Pos R = null, B = null;
        for (int i = 0; i < N; ++i) {
            String line = reader.readLine();
            for (int j = 0; j < M; ++j) {
                board[i][j] = line.charAt(j);

                if (board[i][j] == 'R') {
                    R = new Pos(i, j);
                    board[i][j] = '.';
                } else if (board[i][j] == 'B') {
                    B = new Pos(i, j);
                    board[i][j] = '.';
                }
            }
        }
        int count = calculate(B, R);
        System.out.println(count > 10 ? -1 : count);
    }

    static int calculate(Pos B, Pos R) {
        que.add(new Memory(B,R));
        for (int d = 0; d < 4; ++d)
            visited[R.i][R.j][B.i][B.j] = true;
        int count = 1;
        while (!que.isEmpty()) {
            int size = que.size();
            while (size-->0) {
                Memory m = que.poll();

                for (int d = 0; d < 4; ++d) {
                    if (move(m, d))
                        return count;
                }
            }
            count++;
        }
        return -1;
    }

    static boolean move(Memory m, int d) {
        Pos R = new Pos(m.R.i, m.R.j);
        Pos B = new Pos(m.B.i, m.B.j);

        // 빨간 구슬을 먼저 움직인다.
        Pos nR = moveBall(R, B, d);

        // 파란 구슬을 만났을 때 처리
        // 파란 구슬을 움직이고 난 후, 다시 빨간 구슬을 움직인다.
        if (nR != null && isSamePos(nR.i, nR.j, B)) {
            Pos nB = moveBall(B, R, d);
            if (nB != null && board[nB.i][nB.j] == 'O') return false;
            nR = moveBall(R, B, d);
        }

        // 구멍을 만났을 때 처리
        // 파란 구슬을 움직였을 때 구멍에 빠지지 않는다면 통과 처리
        if (nR != null && board[nR.i][nR.j] == 'O') {
            Pos nB = moveBall(B, nR, d);
            return nB == null || board[nB.i][nB.j] != 'O';
        }
        // 빨간 구슬의 움직임이 이상 없을 때 파란 구슬 움직임
        else {
            Pos nB = moveBall(B, R, d);
            if (nB != null && board[nB.i][nB.j] == 'O') return false;
        }

        // 구슬의 움직임이 모두 멈춤
        // 방문 확인 후 Que에 추가
        if (!visited[R.i][R.j][B.i][B.j]) {
            visited[R.i][R.j][B.i][B.j] = true;
            que.add(new Memory(new Pos(B.i, B.j), new Pos(R.i, R.j)));
        }

        return false;
    }

    static Pos moveBall(Pos cur, Pos other, int d) {
        int di = ds[d][0];
        int dj = ds[d][1];

        int ni = cur.i + di;
        int nj = cur.j + dj;

        while (isValidPos(ni, nj, other)) {
            cur.i = ni;
            cur.j = nj;

            ni = cur.i + di;
            nj = cur.j + dj;
        }

        if (isValidRange(ni, nj)) return new Pos(ni, nj);
        else return null;
    }

    static boolean isValidPos(int ni, int nj, Pos other) {
        if (isValidRange(ni,nj)) {
            boolean isSamePos = isSamePos(ni, nj, other);
            boolean isEmptySpace = board[ni][nj] == '.';

            return !isSamePos && isEmptySpace;
        }

        return false;
    }

    private static boolean isSamePos(int ni, int nj, Pos other) {
        return ni == other.i && nj == other.j;
    }

    private static boolean isValidRange(int ni, int nj) {
        return  0 <= ni && ni < N &&
                0 <= nj && nj < M;
    }

    static class Memory {
        public Pos B;
        public Pos R;

        public Memory(Pos b, Pos r) {
            B = b;
            R = r;
        }
    }

    static class Pos {
        public int i, j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
