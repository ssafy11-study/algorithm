// Subject: Study of Algorithm with SSAFY
// ProblemNo: B11659
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static final int MX = 100101;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, s, e, v[];
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        v = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            v[i] = Integer.parseInt(st.nextToken());
            if(i > 0) v[i] += v[i - 1];
        }
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken()); s--;
            e = Integer.parseInt(st.nextToken()); e--;
            sb.append(v[e] - (s > 0? v[s - 1] : 0)).append('\n');
        }
        System.out.print(sb);
    }
}