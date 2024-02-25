// Subject: Study of Algorithm with SSAFY
// ProblemNo: 1167
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    
    static class Info{
        int tar, cost;
        Info(int ...a){
            this.tar = a[0]; this.cost = a[1];
        }
    }
    
    static void dfs(int now, int parent){
        for(Info next : gph[now]){
            if(next.tar == parent) continue;
            dist[next.tar] = dist[now] + next.cost;
            dfs(next.tar, now);
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, S, x, y, d, dist[];
    static ArrayList<Info> gph[];
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        gph = new ArrayList[N + 1];
        dist = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            gph[i] = new ArrayList();
            dist[i] = 1_000_000_000;
        }
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            while(true){
                y = Integer.parseInt(st.nextToken());
                if(y == -1) break;
                d = Integer.parseInt(st.nextToken());
                gph[x].add(new Info(y, d));
            }
        }
        S = 1;
        dfs(S, -1);
        for(int i = 1; i <= N; i++) if(dist[S] < dist[i]) S = i;
        dist[S] = 0;
        dfs(S, -1);
        for(int i = 1; i <= N; i++) if(dist[S] < dist[i]) S = i;
        System.out.println(dist[S]);
    }
}