package SSAFY.study.week8.t1967;

import SSAFY.B형.week1.doublelinkedlist.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N, max, start;
    static List<Node>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
            list[v].add(new Node(u, w));
        }
        max = Integer.MIN_VALUE;
        start = 1;
        dfs(start, 0);
        visited = new boolean[N + 1];
        dfs(start, 0);
        System.out.println(max);
        br.close();
    }

    static void dfs(int x, int sum) {
        if (sum > max) {
            max = sum;
            start = x;
        }
        visited[x] = true;
        for (Node next : list[x]) {
            if (!visited[next.v]) {
                dfs(next.v, sum + next.w);
            }
        }
    }
    static class Node {
        int v, w;
        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}

