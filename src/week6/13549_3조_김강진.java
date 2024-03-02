import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
// 0 - 1 BFS
public class Main {
    static int N,K;
    static boolean visited[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        visited[N] = true;
        Deque<Node> dq = new LinkedList<>();

        dq.addFirst(new Node(N,0));
        while(!dq.isEmpty()){
            Node node = dq.pollFirst();
            visited[node.p] = true;
            if (node.p == K){
                System.out.println(node.t);
                break;
            }
            if ((node.p *2) <= 100000 && !visited[node.p*2]){
                dq.addFirst(new Node(node.p*2,node.t));
            }
            if((node.p -1) >= 0 && !visited[node.p-1]){
                dq.addLast(new Node(node.p-1,node.t+1));
            }
            if((node.p +1) <= 100000 && !visited[node.p+1]){
                dq.addLast(new Node(node.p+1,node.t+1));
            }
        }

    }

    static class Node{
        int p,t;

        public Node(int p, int t) {
            this.p = p;
            this.t = t;
        }
    }
}
