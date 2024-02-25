// Subject: Study of Algorithm with SSAFY
// ProblemNo: 15654
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static void backTracking(int cnt){
        if(cnt == M){
            for(int i = 0; i < M; i++) sb.append(v[i]).append(" ");
            sb.append('\n');
            return;
        }
        
        for(int i = 0; i < N; i++){
            if(pick[i] > 0) continue;
            v[cnt] = p[i];
            pick[i]++;
            backTracking(cnt + 1);
            pick[i]--;
        }
    }
    
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, sz, p[], pick[], v[];
    static ArrayList<ArrayList<Integer>> res = new ArrayList();
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        p = new int[N]; pick = new int[N]; v = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) p[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(p);
        backTracking(0);
        System.out.print(sb);
        
    }
}