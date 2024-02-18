import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int[] parents = new int[N + 1];
        int n1, n2;
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>());
        for(int i = 1; i <=N; i++){
            graph.add(new ArrayList<>());
        }
        parents[1] = 1;
        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        for(int n : graph.get(1)){
            queue.add(new int[] {n, 1});
            parents[n] = 1;
        }
        int[] rel;
        while(!queue.isEmpty()){
            rel = queue.poll();
            parents[rel[0]] = rel[1];
            for(int n : graph.get(rel[0])){
                if(parents[n] != 0) continue;
                queue.add(new int[] {n, rel[0]});
                parents[n] = rel[0];
            }
        }

        for(int i = 2; i <= N; i++) {
            sb.append(parents[i]).append('\n');
        }
        System.out.println(sb);
    }
}
