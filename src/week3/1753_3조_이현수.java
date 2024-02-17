package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    int index;
    int cost;
    Node(int index, int cost){
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
public class _1753_3조_이현수 {
    static int INF = Integer.MAX_VALUE;
    static ArrayList<Node>[] graph;
    static int[] distance;
    static boolean[] vtd;

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>(); // 코스트 순서대로 저장되는 pq

        // distance의 초기값은 INF
        distance[start] = 0; // 시작 노드는 비용이 0
        pq.add(new Node(start, 0));
        while(!pq.isEmpty()){
            int nowVertex = pq.poll().index;
            if(vtd[nowVertex]) continue;
            vtd[nowVertex] = true;
            for(Node node : graph[nowVertex]){
                if(distance[node.index] > distance[nowVertex] + node.cost)
                    distance[node.index] = distance[nowVertex] + node.cost;

                pq.add(new Node(node.index, distance[node.index]));
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int V, E, K; // V 정점의 개수, E 간선의 개수, K 시작 정점
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V+1];
        vtd = new boolean[V+1];
        distance = new int[V+1];
        Arrays.fill(distance, INF);

        for(int i = 1; i < V+1; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // u 에서
            int v = Integer.parseInt(st.nextToken()); // v 로
            int w = Integer.parseInt(st.nextToken()); // w 만큼의 비용


            graph[u].add(new Node(v, w));
        }

        dijkstra(K);

        for(int i = 1; i < distance.length; i++){
            if(distance[i] == INF)sb.append("INF").append(" ");
            else sb.append(distance[i]).append(" ");
        }

        System.out.print(sb);

    }
}
