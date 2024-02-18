// Subject: Study of Algorithm with SSAFY
// ProblemNo: B11725
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    
    static void dfs(int now){
        for(Integer next : gph[now]){
            if(par[now] == next) continue;
            par[next] = now;
            dfs(next);
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, x, y, par[];
    static ArrayList<Integer> gph[];
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        gph = new ArrayList[N];
        par = new int[N];
        for(int i = 0; i < N; i++) gph[i] = new ArrayList();
        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()); x--;
            y = Integer.parseInt(st.nextToken()); y--;
            gph[x].add(y);
            gph[y].add(x);
        }
        par[0] = -1;
        dfs(0);
        for(int i = 1; i < N; i++) sb.append(par[i] + 1).append('\n');
        System.out.print(sb);
    }
}