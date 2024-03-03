import java.util.*;
import java.io.*;

class Node{
    int no, cost;

    public Node(int no, int cost) {
        this.no = no;
        this.cost = cost;
    }
}
public class Main {
    static int N, K;
    static boolean[] visited;
    static Deque<Node> queue = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100_001];
        visited[N] = true;
        queue.add(new Node(N, 0));

        while (!queue.isEmpty()) {
            Node n = queue.pollFirst();
            if(n.no == K) {
                System.out.println(n.cost);
                return ;
            }
            int next = n. no * 2;
            if (next <= K + 2 && !visited[next]) {
                visited[next] = true;
                queue.offerFirst(new Node( next, n.cost));
            }
            next = n.no - 1;
            if (next >= 0 && !visited[next]) {
                visited[next] = true;
                queue.offerLast(new Node( next, n.cost + 1));
            }
            next = n.no + 1;
            if (next <= 100000 && !visited[next]) {
                visited[next] = true;
                queue.offerLast(new Node( next, n.cost + 1));
            }
        }
    }
}
