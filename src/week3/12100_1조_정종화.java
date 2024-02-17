// Subject: Study of Algorithm with SSAFY
// ProblemNo: 12100
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static void init(int cnt) { for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) {board[cnt + 1][i][j] = 0; updated[i][j] = 0;} }

    static void update(int cnt, int x, int y, int idx){
        if(board[cnt][x][y] == 0) return;
        int value = board[cnt][x][y];
        int k = 0;
        int dx, dy;
        dx = dy = 0;
        while(true){
            dx = x + ("1102".charAt(idx) - '1') * k;
            dy = y + ("0211".charAt(idx) - '1') * k;
            if(dx >= 0 && dx < N && dy >= 0 && dy < N && board[cnt + 1][dx][dy] == 0) k++;
            else break;
        }
        if(dx >= 0 && dx < N && dy >= 0 && dy < N && board[cnt + 1][dx][dy] == value && updated[dx][dy] != 1){
            board[cnt + 1][dx][dy] += value;
            updated[dx][dy] = 1;
        }
        else board[cnt + 1][dx - ("1102".charAt(idx) - '1')][dy - ("0211".charAt(idx) - '1')] += value;
    }

    static void backTracking(int cnt){
        if(cnt == 5){
            for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) res = Math.max(res, board[5][i][j]);
            return;
        }
        init(cnt); { for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) update(cnt, i, j, 0); } backTracking(cnt + 1); //left
        init(cnt); { for(int i = 0; i < N; i++) for(int j = N - 1; j >= 0; j--) update(cnt, i, j, 1); } backTracking(cnt + 1); //right
        init(cnt); { for(int j = 0; j < N; j++) for(int i = 0; i < N; i++) update(cnt, i, j, 2); } backTracking(cnt + 1); //up
        init(cnt); { for(int j = 0; j < N; j++) for(int i = N - 1; i >= 0; i--) update(cnt, i, j, 3); } backTracking(cnt + 1); //down
    }


	static final int MX = 10001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, board[][][], updated[][], res;
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        board = new int[6][N][N];
        updated = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) board[0][i][j] = Integer.parseInt(st.nextToken());
        }
        backTracking(0);
        System.out.println(res);
    }
}
