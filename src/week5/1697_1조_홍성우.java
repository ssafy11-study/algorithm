package 알고리즘_스터디._5주차.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _1697 {
    static int N, K;
    static int[] visited;

    static class Node {
        int index;
        int count;

        Node(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[100001];

        System.out.println(bfs());
    }

    public static int bfs() {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(N, 0));
        visited[N] = 1;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int curPosition = current.index;
            int curTime = current.count;

            if (curPosition == K) {
                return curTime;
            }

            if (curPosition - 1 >= 0 && visited[curPosition - 1] == 0) {
                queue.add(new Node(current.index - 1, current.count + 1));
                visited[curPosition - 1] = 1;
            }
            if (curPosition + 1 <= 100000 && visited[curPosition + 1] == 0) {
                queue.add(new Node(current.index + 1, current.count + 1));
                visited[curPosition + 1] = 1;
            }
            if (curPosition * 2 <= 100000 && visited[curPosition * 2] == 0) {
                queue.add(new Node(current.index * 2, current.count + 1));
                visited[curPosition * 2] = 1;
            }
        }
        return -1;
    }
}
