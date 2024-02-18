// Subject: Study of Algorithm with SSAFY
// ProblemNo: B18870
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    
    static class Info{
        int val, idx, res;
        Info(int ...a){
            this.val = a[0];
            this.idx = a[1];
            this.res = 0;
        }
    }
    
	static final int MX = 1000000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, x;
    static ArrayList<Info> v = new ArrayList();

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) v.add(new Info(Integer.parseInt(st.nextToken()), i));
        v.sort((o1, o2)->o1.val - o2.val);
        for(int i = 1; i < N; i++) v.get(i).res = v.get(i - 1).res + (v.get(i).val != v.get(i - 1).val? 1 : 0);
        v.sort((o1, o2)->o1.idx - o2.idx);
        for(int i = 0; i < N; i++) sb.append(v.get(i).res).append(" ");
        System.out.print(sb);
    }
}