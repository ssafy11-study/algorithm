// Subject: Study of Algorithm with SSAFY
// ProblemNo: 1197
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

	static final int MX = 10000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
	static int V, E, A, B, C, res, cnt, par[];

    static class Edge{
        int x, y, d;
        Edge(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    static PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2)-> o1.d - o2.d);
    
    static int find(int X){
        if(X == par[X]) return X;
        return par[X] = find(par[X]);
    }
    
    static boolean merge(int a, int b){
        a = find(a); b = find(b);
        if(a == b) return false;
        if(a > b) par[a] = b;
        else par[b] = a;
        return true;
    }
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken()); A--;
            B = Integer.parseInt(st.nextToken()); B--;
            C = Integer.parseInt(st.nextToken());
            pq.add(new Edge(A, B, C));
        }
        par = IntStream.range(0, V).toArray();
        cnt = V - 1;
        
        while(cnt > 0 && !pq.isEmpty()){
            Edge now = pq.remove();
            if(merge(now.x, now.y)){
                res += now.d;
                cnt--;
            }
        }
        System.out.println(res);
    }
}