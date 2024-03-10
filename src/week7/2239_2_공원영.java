package SSAFY.study.week7.t2239;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {
    static final int N = 9;
    static int zeros=0;
    static int[][] map = new int[N][N];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j)-'0';
                if(map[i][j] == 0) zeros++;
            }
        }
//        System.out.println(zeros);
        backtracking(0);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
    static boolean backtracking(int cnt) {
        if (cnt == zeros) {
            return true;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] != 0) continue;
                for (int k = 1; k <= 9; k++) {
                    // i행에 map[i][j]가 이미 있는가?
                    // j열에 map[i][j]가 이미 있는가?
                    // i%3, j%3번 그리드에 map[i][j]가 있는가?
                    if (dupleGrid(i, j, k) && dupleCol(j, k) && dupleRow(i, k)) {
                        map[i][j] = k;
                        boolean b = backtracking(cnt + 1);
                        if(b) return b;
                        map[i][j] = 0;
                    }
                }
                return false;
            }
        }
        return false;
    }
    static boolean dupleGrid(int row, int col, int x) {
        int r = (row / 3) * 3;
        int c = (col / 3) * 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if(map[i][j] == x) return false;
            }
        }
        return true;
    }
    static boolean dupleRow(int row, int x) {
        for (int col = 0; col < N; col++) {
            if(map[row][col]  == x) return false;
        }
        return true;
    }

    static boolean dupleCol(int col, int x) {
        for (int row = 0; row < N; row++) {
            if(map[row][col] == x) return false;
        }
        return true;
    }
}
