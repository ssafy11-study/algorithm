import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] adj;
    static int N;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adj = new List[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; ++i) {
            adj[i] = new LinkedList<>();
        }

        while (M-->0) {
            st = new StringTokenizer(reader.readLine());
            Integer s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adj[e].add(s);
        }
        for (int i = 1; i <= N; ++i)
            visit(i);
        System.out.println(sb);
    }

    static void visit(int i) {
        for (Integer f : adj[i]) {
            if (!visited[f]) visit(f);
        }
        if (!visited[i]) {
            sb.append(i).append(' ');
            visited[i] = true;
        }
    }
}