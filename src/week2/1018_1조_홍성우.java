package 알고리즘_스터디._2주차.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int minRepaint = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                minRepaint = Math.min(minRepaint, findMinRepaint(board, i, j));
            }
        }

        System.out.println(minRepaint);
    }

    private static int findMinRepaint(char[][] board, int x, int y) {
        int endX = x + 8;
        int endY = y + 8;
        int count1 = 0;
        int count2 = 0;

        for (int i = x; i < endX; i++) {
            for (int j = y; j < endY; j++) {
                if ((i + j) % 2 == 0) {
                    if (board[i][j] != 'W') count1++;
                    if (board[i][j] != 'B') count2++;
                } else {
                    if (board[i][j] != 'B') count1++;
                    if (board[i][j] != 'W') count2++;
                }
            }
        }

        return Math.min(count1, count2);
    }
}