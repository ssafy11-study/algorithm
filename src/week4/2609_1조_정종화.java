// Subject: Study of Algorithm with SSAFY
// ProblemNo: B2609
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    
    static int gcd(int x, int y){
        if(y == 0) return x;
        return gcd(y, x % y);
    }
    
	static final int MX = 10001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int A, B, G;
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        G = gcd(A, B);
        System.out.printf("%d\n%d", G, A * B / G);
    }
}