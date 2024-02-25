// Subject: Study of Algorithm with SSAFY
// ProblemNo: 2150
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    
    static int scc(int now){
        dn[now] = ++dfsn;
        stack.push(now);
        int FLAG = dn[now];
        for(int next : gph[now]){
            if(g[next] != 0) continue;
            if(dn[next] != 0) FLAG = Math.min(FLAG, dn[next]);
            else FLAG = Math.min(FLAG, scc(next));
        }
        if(FLAG == dn[now]){
            ++gn;
            ArrayList<Integer> tmp = new ArrayList();
            while(true){
                int t = stack.pop();
                tmp.add(t); g[t] = gn;
                if(t == now) break;
            }
            group.add(tmp);
        }
        return FLAG;
    }
    
    static final int MX = 16_000_002;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int V, E, x, y, dn[], g[], dfsn, gn;
    static ArrayList<ArrayList<Integer>> group = new ArrayList();
    static ArrayList<Integer> gph[];
    static ArrayDeque<Integer> stack = new ArrayDeque();
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        gph = new ArrayList[V];
        for(int i = 0; i < V; i++) gph[i] = new ArrayList();
        dn = new int[V]; g = new int[V];
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()); x--;
            y = Integer.parseInt(st.nextToken()); y--;
            gph[x].add(y);
        }
        
        for(int i = 0; i < V; i++) if(dn[i] == 0) scc(i);
        
        sb.append(group.size()).append('\n');
        for(int i = 0; i < group.size(); i++) Collections.sort(group.get(i));
        Collections.sort(group, (o1, o2) -> o1.get(0) - o2.get(0));
        
        for(ArrayList<Integer> list : group){
            for(int tar : list) sb.append(tar + 1).append(' ');
            sb.append(-1).append('\n');
        }
        System.out.print(sb);
    }
}