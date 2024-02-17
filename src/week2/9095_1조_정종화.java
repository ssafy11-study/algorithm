// Subject: Study of Algorithm with SSAFY
// ProblemNo: 9095
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
	static int T, N, dp[];

    static void init(){
        dp = new int[MX];
        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        for(int i = 4; i < MX; i++) dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }

    public static void main(String[] args) throws Exception{
        init();
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }
}
