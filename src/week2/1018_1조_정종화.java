// Subject: Study of Algorithm with SSAFY
// ProblemNo: 1018
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
	
	static final int MX = 12;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Deque<Integer> queue = new ArrayDeque<>();
    static int N, M, isCorrect[][][], w[][][], res;

    static void init() throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isCorrect = new int[2][N][M];
        w = new int[2][N + 1][M + 1];
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                isCorrect[(((i + j) % 2 == 0) ^ (s.charAt(j) == 'W'))? 1:0][i][j]++;
                w[0][i + 1][j + 1] = isCorrect[0][i][j] + w[0][i + 1][j] + w[0][i][j + 1] - w[0][i][j];
                w[1][i + 1][j + 1] = isCorrect[1][i][j] + w[1][i + 1][j] + w[1][i][j + 1] - w[1][i][j];
            }
        }
    }
    
    static int query(int idx, int x, int y) { return w[idx][x + 8][y + 8] - w[idx][x][y + 8] - w[idx][x + 8][y] + w[idx][x][y]; }

    public static void main(String[] args) throws Exception{
        init();
        res = 64;
        for(int i = 0; i < N - 7; i++){
            for(int j = 0; j < M - 7; j++){
                int ret = Math.min(query(0, i, j), query(1, i, j));
                res = Math.min(res, ret);
            }
        }
        System.out.println(res);
    }
}