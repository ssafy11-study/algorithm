package 알고리즘_스터디._5주차.class4;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1167 {
    static class Node {
        int to, weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static ArrayList<ArrayList<Node>> arrayList;
    static boolean[] visited;
    static int answer = 0;
    static int farthestNode = 0;


    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(bf.readLine());

        arrayList = new ArrayList<>();
        visited = new boolean[V + 1];

        for (int i = 0; i <= V; i++) {
            arrayList.add(new ArrayList<>());

        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int target = Integer.parseInt(st.nextToken());
            while (st.hasMoreElements()) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == -1) {
                    break;
                } else {
                    arrayList.get(target).add(new Node(temp, Integer.parseInt(st.nextToken())));
                }
            }
        }

        // 가장 먼 정점 찾기
        // 여기서 가장 먼 정점이란 가중치가 가장 높은것을 말하는 것이다.
        dfs(1, 0);

        visited = new boolean[V + 1];
        answer = 0;

        // 제일 먼 노드를 찾았으니 거기 기준에서 dfs 를 통해 가장 먼 노드까지 거리 구한다
        dfs(farthestNode, 0);

        System.out.println(answer);;
    }

    static void dfs(int start, int weight) {
        if(visited[start]) {
            return;
        }

        visited[start] = true;

        if (weight > answer) {
            answer = weight;
            farthestNode = start;

        }
        ArrayList<Node> nodeList = arrayList.get(start);
        for(Node node : nodeList) {
            dfs(node.to, weight + node.weight);
        }
    }
}
