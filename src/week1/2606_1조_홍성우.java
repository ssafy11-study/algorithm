package 알고리즘_스터디._1주차.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class _2606 {

    public static int answer;

    public static boolean[] visited;

    public static List<List<Integer>> adjList;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        visited = new boolean[N + 1];
        adjList = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(b).add(a);

        }
        answer = -1;
        dfs(1);
        System.out.println(answer);
    }

    public static void dfs(int node) {
        if (visited[node]) {
            return;
        }
        answer++;
        visited[node] = true;
        for (int i : adjList.get(node)) {
            dfs(i);
        }
    }
}