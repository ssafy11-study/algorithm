// Subject: Study of Algorithm with SSAFY
// ProblemNo: 11280
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {

	static final int MX = 10000;
	static final int BOUND = 10000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
	static int N, M, x, y, dfsn[], g[], dn, gn;
	static ArrayList<Integer>[] gph;
    static Deque<Integer> stack;

    static int getSCC(int now){
        dfsn[now] = ++dn;
        int FLAG = dfsn[now];
        stack.addLast(now);
        
        for(int tar: gph[now]){
            if(g[tar] > 0) continue;
            if(dfsn[tar] == 0) FLAG = Math.min(FLAG, getSCC(tar));
            else FLAG = Math.min(FLAG, dfsn[tar]);
        }
        if(FLAG == dfsn[now]){
            gn++;
            while(true && !stack.isEmpty()){
                int t = stack.removeLast();
                g[t] = gn;
                if(t == now) break;
            }
        }
        return FLAG;
    }
    
    public static void main(String[] args) throws Exception{
        stack = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        gph = new ArrayList[2 * BOUND + 1];
        for(int i = 0; i < 2 * BOUND + 1; i++) gph[i] = new ArrayList();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            gph[-x + BOUND].add(y + BOUND);
            gph[-y + BOUND].add(x + BOUND);
        }
        dfsn = new int[2 * BOUND + 1];
        g = new int[2 * BOUND + 1];
        dn = gn = 0;
        for(int i = BOUND + 1; i <= BOUND + N; i++) if(dfsn[i] == 0) getSCC(i);
        for(int i = BOUND - N; i < BOUND; i++) if(dfsn[i] == 0) getSCC(i);
        boolean FLAG = true;
        for(int i = 1; i <= N; i++) FLAG &= (g[BOUND - i] != g[BOUND + i]);
        System.out.println(FLAG? 1 : 0);
    }
}
