// Subject: Study of Algorithm with SSAFY
// ProblemNo: 1074
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

	static final int MX = 10001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
	static int N, R, C, res;
	
	static int solve(int n, int r, int c, int idx){
	    if(n == 1) return idx + (r * 2 + c);
	    int t = 0;
	    int p = (1 << (n - 1));
	    if(r >= p) { t += 2; r -= p; }
	    if(c >= p) { t += 1; c -= p; }
	    return solve(n - 1, r, c, idx + t * (1 << 2 * n - 2));
	}

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        System.out.print(solve(N, R, C, 0));
    }
}
