import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static char[][] maps;
    static int limitX;
    static int limitY;
    static int N, M;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // // 입력값 초기화
        maps = new char[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            maps[i] = st.nextToken().toCharArray();
        }

        // 세로 제한 구하기
        limitX = M - 7;
        limitY = N - 7;

        int black;
        int white;
        int result = 0;
        List<Integer> results = new ArrayList<>();

        // 반복하면서 체크
        for (int i = 0; i < limitY; i++) { // Y(세로)
            for (int j = 0; j < limitX; j++) { // X(가로)
                white = checkMap(j, i, 'W');
                black = checkMap(j, i, 'B');
                result = Math.min(black, white);
                results.add(result);
            }
        }

        System.out.println(Collections.min(results));
    }

    static int checkMap(int x, int y, char block) {
        int count = 0;
        char[][] temp = new char[N][M];

        for (int i = 0; i<N; i++) {
            for (int j=0; j<M; j++) {
                temp[i][j] = maps[i][j];
            }
        }

        for (int i = y; i < (8 + y); i++) {
            for (int j = x; j < (8 + x); j++) {
                if(temp[i][j] != block) { 
                    temp[i][j] = (temp[i][j] == 'W') ? 'B':'W';
                    count++;
                }
                block = (temp[i][j] == 'W') ? 'B':'W';
            }
            block = (block == 'W') ? 'B':'W';
        }
        return count;
    }
}