// Subject: Study of Algorithm with SSAFY
// ProblemNo: B11724
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static void dfs(int now){
        for(int next : gph[now]){
            if(!vtd[next]){
                vtd[next] = true;
                dfs(next);
            }
        }
    }

    static final int MX = 100101;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, x, y, res;
    static ArrayList<Integer> gph[];
    static boolean vtd[];
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        gph = new ArrayList[N];
        for(int i = 0; i < N; i++) gph[i] = new ArrayList();
        vtd = new boolean[N];
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()); x--;
            y = Integer.parseInt(st.nextToken()); y--;
            gph[x].add(y);
            gph[y].add(x);
        }
        
        for(int i = 0; i < N; i++){
            if(!vtd[i]){
                res++;
                dfs(i);
            }
        }
        System.out.print(res);
    }
}