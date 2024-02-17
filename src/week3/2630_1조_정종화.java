// Subject: Study of Algorithm with SSAFY
// ProblemNo: 2630
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static void solve(int x, int y, int len){
        int cnt = w[x + len][y + len] - w[x + len][y] - w[x][y + len] + w[x][y];
        if(cnt == len * len || cnt == 0){
            res[(cnt == len * len)? 1 : 0]++;
            return;
        }
        len /= 2;
        solve(x, y, len);
        solve(x + len, y, len);
        solve(x, y + len, len);
        solve(x + len, y + len, len);
    }

	static final int MX = 10001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, x, w[][], res[];
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        w = new int[N + 1][N + 1];
        res = new int[2];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                x = Integer.parseInt(st.nextToken());
                w[i + 1][j + 1] = x + w[i][j + 1] + w[i + 1][j] - w[i][j];
            }
        }
        solve(0, 0, N);
        System.out.print(res[0] + "\n" + res[1]);
    }
}
