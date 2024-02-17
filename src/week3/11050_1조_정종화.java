// Subject: Study of Algorithm with SSAFY
// ProblemNo: 11050
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {


	static final int MX = 10001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, K, res;
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        res = 1;
        for(int i = 1; i <= N; i++) res *= i;
        for(int i = 1; i <= K; i++) res /= i;
        for(int i = 1; i <= N - K; i++) res /= i;
        System.out.println(res);
    }
}