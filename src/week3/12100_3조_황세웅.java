import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int n;
    static final int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 하 좌 우

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Board init = new Board();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                init.setBoard(i, j, Integer.parseInt(st.nextToken()));
            }
        }

        Deque<Depth> queue = new ArrayDeque<>();
        queue.offer(new Depth(init, 0));

        int ans = 0;
        while (!queue.isEmpty()) {
            Depth curr = queue.poll();
            if (curr.depth == 5) {
                ans = Math.max(ans, curr.board.getMax());
                continue;
            }
            for (int d = 0; d < 4; d++) {
                Board next = new Board(curr.board.board);
                next.move(d);
                queue.offer(new Depth(next, curr.depth + 1));
            }
        }

        System.out.println(ans);
    }

    static class Depth {
        Board board;
        int depth;

        Depth(Board board, int depth) {
            this.board = board;
            this.depth = depth;
        }
    }

    static class Board {
        int[][] board = new int[n][n];
        boolean[][] blocked = new boolean[n][n];

        void print() {
            for (int i = 0; i < n; i++) {
                System.out.println(Arrays.toString(board[i]));
            }
            System.out.println();
        }

        Board() {

        }

        Board(int[][] board) {
            for (int i = 0; i < n; i++) {
                this.board[i] = board[i].clone();
            }
        }

        void setBoard(int i, int j, int v) {
            this.board[i][j] = v;
        }

        int getMax() {
            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    max = Math.max(max, board[i][j]);
                }
            }
            return max;
        }

        void move(int d) {
            boolean[][] visited = new boolean[n][n];
            Deque<Pos> queue = new ArrayDeque<>();

            Pos start = startPoint(d);
            queue.offer(start);
            visited[start.row][start.column] = true;

            while (!queue.isEmpty()) {
                Pos curr = queue.poll();
                for (int[] t : direction) {
                    int nextRow = curr.row + t[0];
                    int nextColumn = curr.column + t[1];

                    if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n) {
                        continue;
                    }
                    if (visited[nextRow][nextColumn]) {
                        continue;
                    }
                    moveBlock(d, nextRow, nextColumn);
                    visited[nextRow][nextColumn] = true;
                    queue.add(new Pos(nextRow, nextColumn));
                }
            }
        }

        void moveBlock(int d, int row, int column) {
            int nextRow = row;
            int nextColumn = column;

            while (true) {
                int currRow = nextRow;
                int currColumn = nextColumn;

                nextRow += direction[d][0];
                nextColumn += direction[d][1];

                if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n) {
                    break;
                }
                if (blocked[nextRow][nextColumn]) {
                    break;
                }

                if (board[nextRow][nextColumn] == 0) {
                    board[nextRow][nextColumn] = board[currRow][currColumn];
                    board[currRow][currColumn] = 0;
                    continue;
                }
                if (board[nextRow][nextColumn] == board[currRow][currColumn]) {
                    board[nextRow][nextColumn] *= 2;
                    board[currRow][currColumn] = 0;
                    blocked[nextRow][nextColumn] = true;
                    break;
                }
                break;
            }
        }

        Pos startPoint(int d) {
            switch (d) {
                case 0: // 상
                case 2: // 좌
                    return new Pos(0, 0);
                case 1: // 하
                    return new Pos(n - 1, 0);
                default: // 우
                    return new Pos(0, n - 1);
            }
        }
    }

    static class Pos {
        int row;
        int column;

        Pos(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
