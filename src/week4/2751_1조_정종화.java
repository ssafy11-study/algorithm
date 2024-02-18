// Subject: Study of Algorithm with SSAFY
// ProblemNo: B2751
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

	static final int MX = 10001;
	static final int BOUND = 1000000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayDeque<Integer> dq = new ArrayDeque();
    static String s;
    static int num[], N, x;
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        num = new int[2 * BOUND + 1];
        for(int n = 0; n < N; n++){
            x = Integer.parseInt(br.readLine());
            num[x + BOUND]++;
        }
        for(int i = 0; i < 2 * BOUND + 1; i++) for(int j = 0; j < num[i]; j++) sb.append(i - BOUND).append('\n');
        System.out.print(sb);
    }
}