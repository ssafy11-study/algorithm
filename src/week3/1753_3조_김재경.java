import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
    int index;
    int distance;

    public Node(int index, int distance){
        this.index = index;
        this.distance = distance;
    }
    @Override
    public int compareTo(Node o) {
        if(this.distance < o.distance){
            return -1;
        }
        return 1;
    }
}
public class Main {
    static int V; //vertex
    static int E; // edge
    static int start;
    static final int INF = 100000001;
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);
        start = Integer.parseInt(br.readLine());
        d = new int[V+1];
        Arrays.fill(d,INF);
        ArrayList<ArrayList<Node>> nodes= new ArrayList<>();

        for(int i=0; i<=V; i++){
            nodes.add(new ArrayList<Node>());
        }

        for(int i=0; i<E; i++){
            input =br.readLine().split(" ");
            nodes.get(Integer.parseInt(input[0])).add(new Node(Integer.parseInt(input[1]),Integer.parseInt(input[2])));
        }
        dijkstra(nodes);
        for(int i=1; i<d.length; i++){
            if(d[i]==INF){
                System.out.println("INF");
            }
            else{
                System.out.println(d[i]);
            }
        }
    }

    private static void dijkstra(ArrayList<ArrayList<Node>> nodes) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int idx= node.index;
            int dist = node.distance;

            if(d[idx]<dist){
                continue;
            }
            for(int i = 0; i< nodes.get(idx).size(); i++){
                Node n_node = nodes.get(idx).get(i);
                int cost = d[idx] + n_node.distance;
                if(cost < d[n_node.index] ){
                    d[n_node.index] = cost;
                    pq.offer(new Node(n_node.index , cost));
                }
            }
        }
    }
}