import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int blue = 0;
    static int white = 0;

    static boolean check(int x, int y, int size) {
        int first = map[x][y];
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(map[i][j] != first) return false;
            }
        }
        return true;
    }

    static void search(int x, int y, int size) {

        if(check(x, y, size)) {
            if(map[x][y] == 1) blue++;
            else white++;
            return ;
        }

        size /= 2;

        search(x, y, size);
        search(x + size, y, size);
        search(x, y + size, size);
        search(x + size, y + size, size);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        search(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }
}
