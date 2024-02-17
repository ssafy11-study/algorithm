import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parents = new int[V+1];
        for (int i = 1; i <= V; ++i) parents[i] = i;

        List<Edge> edges = new LinkedList<>();

        int iter = E;

        while (iter-->0) {
            st = new StringTokenizer(reader.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a,b,v));
        }

        int sum = edges.stream()
                .sorted((a,b)->a.v-b.v)
                .filter(e->union(e.a, e.b))
                .limit(V-1)
                .mapToInt(e->e.v)
                .sum();

        System.out.println(sum);
    }

    public static boolean union(int a, int b) {
        int pa = findAncestor(a);
        int pb = findAncestor(b);

        if (pa == pb) return false;

        parents[pb] = pa;

        return true;
    }

    public static int findAncestor(int n) {
        if (n == parents[n]) return n;
        else return parents[n] = findAncestor(parents[n]);
    }

    static class Edge {
        public int a, b, v;

        public Edge(int a, int b, int v) {
            this.a = a;
            this.b = b;
            this.v = v;
        }
    }
}
