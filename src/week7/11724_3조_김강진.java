import java.util.*;
import java.io.*;
public class Main {
    static boolean[] visited;
    static List<List<Integer>> adj = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        for(int i=0;i<=N;i++){
            adj.add(new ArrayList<>());
        }

        for (int i=0;i<M;i++){
            st= new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int ans =0;
        for (int i=1;i<=N;i++){
            if (!visited[i]){
                bfs(i);
                ans++;
            }
        }
        System.out.println(ans);
    }

    static void bfs(int src){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);

        while(!q.isEmpty()){
            int tmp = q.poll();
            visited[tmp] = true;
            for (int i =0;i<adj.get(tmp).size();i++){
                int res = adj.get(tmp).get(i);
                if (!visited[res]){
                    visited[res] = true;
                    q.add(res);
                }
            }
        }
    }
}