// Subject: Study of Algorithm with SSAFY
// ProblemNo: 1920
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static class Info{
        int val, idx;
        Info(int ...a){
            this.val = a[0]; this.idx = a[1];
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static Info query[];
    static int N, M, v[], res[];
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        v = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) v[i] = Integer.parseInt(st.nextToken());
        
        M = Integer.parseInt(br.readLine());
        query = new Info[M]; res = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) query[i] = new Info(Integer.parseInt(st.nextToken()), i);

        Arrays.sort(v);
        Arrays.sort(query, (o1, o2) -> (o1.val > o2.val? 1 : o1.val < o2.val? -1 : 0));
        
        int l, r;
        l = r = 0;
        while(l < N && r < M){
            if(v[l] == query[r].val) res[query[r++].idx]++;
            else if(v[l] > query[r].val) r++;
            else l++;
        }
        for(int i = 0; i < M; i++) sb.append(res[i]).append('\n');
        System.out.print(sb);
          
    }
}