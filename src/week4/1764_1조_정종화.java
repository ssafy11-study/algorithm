// Subject: Study of Algorithm with SSAFY
// ProblemNo: B1764
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    
	static final int MX = 1000000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, res;
    static HashSet<String> S = new HashSet();
    static ArrayList<String> v = new ArrayList();
    static String s;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++) S.add(br.readLine());
        for(int i = 0; i < M; i++) {
            s = br.readLine();
            if(S.contains(s)) v.add(s);
        }
        Collections.sort(v);
        for(String x : v) sb.append(x).append('\n');
        System.out.println(v.size());
        System.out.print(sb);
    }
}