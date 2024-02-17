// Subject: Study of Algorithm with SSAFY
// ProblemNo: 15650
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static void solve(int idx, int cnt){
        if(cnt == M){
            for(int i = 0; i < M; i++) System.out.print(w[i] + " ");
            System.out.println();
            return;
        }
        for(int i = idx; i <= N; i++){
            w[cnt] = i;
            solve(i + 1, cnt + 1);
        }
    }

	static final int MX = 10001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, w[];
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        w = new int[M];
        solve(1, 0);
    }
}