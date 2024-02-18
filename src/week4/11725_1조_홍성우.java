import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _11725 {

    static ArrayList<ArrayList<Integer>> arrayList;

    static StringBuilder sb = new StringBuilder();

    static boolean[] visited;

    static int[] parents;

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        parents = new int[N + 1];
        visited = new boolean[N + 1];
        arrayList = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            arrayList.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arrayList.get(a).add(b);
            arrayList.get(b).add(a);
        }

        dfs(1);

        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append("\n");
        }
        System.out.println(sb);

    }

    static void dfs(int node) {
        visited[node] = true;

        for (int child : arrayList.get(node)) {
            if (!visited[child]) {
                parents[child] = node;
                dfs(child);
            }
        }
    }
}
