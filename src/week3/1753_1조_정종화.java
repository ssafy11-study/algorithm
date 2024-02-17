// Subject: Study of Algorithm with SSAFY
// ProblemNo: 2630
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static class Info{
        int tar, cost;
        Info(int...a){
            this.tar = a[0];
            this.cost = a[1];
        }
    }


	static final int MX = 10001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int x, y, d, V, E, K, dist[];
    static ArrayList<Info> gph[];
    static PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2)-> o1.cost - o2.cost);
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine()); K--;
        gph = new ArrayList[V];
        for(int i = 0; i < V; i++) gph[i] = new ArrayList();
        
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()); x--;
            y = Integer.parseInt(st.nextToken()); y--;
            d = Integer.parseInt(st.nextToken());
            gph[x].add(new Info(y, d));
        }
        dist = new int[V];
        for(int i = 0; i < V; i++) dist[i] = 1000000000;
        dist[K] = 0;
        pq.add(new Info(K, dist[K]));
        while(!pq.isEmpty()){
            Info now = pq.remove();
            if(now.cost != dist[now.tar]) continue;
            for(Info next : gph[now.tar]){
                if(dist[next.tar] > dist[now.tar] + next.cost){
                    dist[next.tar] = dist[now.tar] + next.cost;
                    pq.add(new Info(next.tar, dist[next.tar]));
                }
            }
        }
        for(int i = 0; i < V; i++) sb.append((dist[i] == 1000000000)? "INF" : dist[i]).append('\n');
        System.out.println(sb);
    }
}
