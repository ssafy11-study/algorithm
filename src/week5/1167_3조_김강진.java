import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int V,mDist,sIdx;
    static boolean visited[], visited2[];
    static List<List<Node>> tree = new ArrayList<>();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine());
        visited = new boolean[V+1];

        // Initialize Tree
        for (int i=0;i<=V;i++){
            tree.add(new ArrayList<>());
        }

        for (int v=0;v<V;v++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            while(true){
                int tgd = Integer.parseInt(st.nextToken());
                if (tgd == -1) break;
                int dist = Integer.parseInt(st.nextToken());
                tree.get(idx).add(new Node(tgd,dist));
            }
        }

        dfs(1,0);
        visited = new boolean[V+1];
        dfs(sIdx,0);

        System.out.println(mDist);

    }

    static void dfs(int curIdx, int curDist){
        if (curDist > mDist){
            mDist = curDist;
            sIdx = curIdx;
        }

        visited[curIdx] = true;

        for (int i=0;i<tree.get(curIdx).size();i++){
            Node node = tree.get(curIdx).get(i);
            if (visited[node.tgd]) continue;
            dfs(node.tgd, curDist+node.dist);
        }
    }

    static class Node{
        int tgd, dist;
        Node(int tgd, int dist){
            this.tgd = tgd;
            this.dist = dist;
        }
    }
}
