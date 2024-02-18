// Subject: Study of Algorithm with SSAFY
// ProblemNo: B1932
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, v[][], res;
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        v = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= i; j++){
                v[i][j] = Integer.parseInt(st.nextToken());
                v[i][j] += Math.max(v[i - 1][j - 1], v[i - 1][j]);
                if(i == N) res = Math.max(res, v[i][j]);
            }
        }
        System.out.println(res);
    }
}