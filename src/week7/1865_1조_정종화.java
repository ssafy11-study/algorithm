// Subject: Study of Algorithm with SSAFY
// ProblemNo: B1865
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {

    static class Info{
        int tar, cost;
        Info(int...a){
            this.tar = a[0];
            this.cost = a[1];
        }
    }

    static final int MX = 999999;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T, N, M, W, x, y, d, dist[];
    static ArrayList<Info> gph[];
    
    public static void main(String[] args) throws Exception{
        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            
            dist = new int[N];
            gph = new ArrayList[N];
            for(int i = 0; i < N; i++) gph[i] = new ArrayList();
            
            for(int i = 0; i < M + W; i++){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken()); x--;
                y = Integer.parseInt(st.nextToken()); y--;
                d = Integer.parseInt(st.nextToken()); d = (i < M? d : -d);
                gph[x].add(new Info(y, d));
                if(i < M) gph[y].add(new Info(x, d));
            }
            
            for(int k = 0; k < N - 1; k++){
                for(int i = 0; i < N; i++){
                    for(Info next : gph[i]){
                        if(dist[next.tar] > dist[i] + next.cost){
                            dist[next.tar] = dist[i] + next.cost;
                        }
                    }
                }
            }
            
            boolean FLAG = false;
            for(int i = 0; i < N; i++){
                for(Info next : gph[i]){
                    if(dist[next.tar] > dist[i] + next.cost) FLAG = true;
                }
            }
            sb.append(FLAG? "YES\n":"NO\n");
        }
        System.out.print(sb);
    }
}