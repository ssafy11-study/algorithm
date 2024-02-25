// Subject: Study of Algorithm with SSAFY
// ProblemNo: 1012
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static boolean inRange(int x, int y) { return x >= 0 && x < N && y >= 0 && y < M; }

    static void dfs(int x, int y){
        for(int i = 0; i < 4; i++){
            int dx = x + "2011".charAt(i) - '1';
            int dy = y + "1120".charAt(i) - '1';
            if(inRange(dx, dy) && v[dx][dy] > 0){
                v[dx][dy] = 0;
                dfs(dx, dy);
            }
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T, N, M, K, v[][], x, y, res;
    
    public static void main(String[] args) throws Exception{
        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            v = new int[N][M];
            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                v[y][x]++;
            }
            for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
            if(v[i][j] > 0){
                v[i][j]--; res++; dfs(i, j);
            }
            System.out.println(res);
            res = 0;
        }
    }
}