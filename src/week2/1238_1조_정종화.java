// Subject: Study of Algorithm with SSAFY
// ProblemNo: 1238
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static class Info{
        int cost, tar;
        Info(int cost, int tar){
            this.cost = cost;
            this.tar = tar;
        }
    }

	static final int MX = 10001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static ArrayList<Info> gph[], rgph[];
    static PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2)-> o1.cost - o2.cost);
	static int N, M, X, x, y, t, res, dist[], rdist[];
	
	static void init() throws Exception {
	    st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    X = Integer.parseInt(st.nextToken()); X--;
	    gph = new ArrayList[N];
	    rgph = new ArrayList[N];
	    for(int i = 0; i < N; i++){
	        gph[i] = new ArrayList();
	        rgph[i] = new ArrayList();
	    }
	    for(int i = 0; i < M; i++){
	        st = new StringTokenizer(br.readLine());
	        x = Integer.parseInt(st.nextToken()); x--;
	        y = Integer.parseInt(st.nextToken()); y--;
	        t = Integer.parseInt(st.nextToken());
	        gph[x].add(new Info(t, y));
	        rgph[y].add(new Info(t, x));
	    }
	    dist = new int[N];
	    rdist = new int[N];
	}
	
	
    public static void main(String[] args) throws Exception{
        init();
        dijkstra(gph, dist);
        dijkstra(rgph, rdist);
        for(int i = 0; i < N; i++) res = Math.max(res, dist[i] + rdist[i]);
        System.out.println(res);
    }

    static void dijkstra(ArrayList<Info> w[], int ret[]){
        for(int i = 0; i < N; i++) ret[i] = 100000000;
        ret[X] = 0; pq.add(new Info(0, X));
        
        while(!pq.isEmpty()){
            Info now = pq.remove();
            if(now.cost != ret[now.tar]) continue;
            for(Info next : w[now.tar]){
                if(ret[next.tar] > now.cost + next.cost){
                    ret[next.tar] = now.cost + next.cost;
                    pq.add(new Info(ret[next.tar], next.tar));
                }
            }
        }
    }
}
