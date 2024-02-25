import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

static int n,m,sx,sy,cnt=0;
static boolean[][] visited;
static int[][] map, res;

// Delta U D L R;
static int[] dy = {-1,1,0,0};
static int[] dx = {0,0,-1,1};
static Queue<Node> q = new ArrayDeque<>();

static StringBuilder sb = new StringBuilder();
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    map = new int[n][m];
    visited = new boolean[n][m];

    for (int i=0;i<n;i++){
        st = new StringTokenizer(br.readLine());
        for (int j=0;j<m;j++){
            map[i][j] = Integer.parseInt(st.nextToken());
            if (map[i][j] == 2){
                q.offer(new Node(i,j));
                map[i][j] = 0;
                visited[i][j] = true;
            }
        }
    }

    bfs();

    for (int i=0;i<n;i++){
        for (int j=0;j<m;j++){
            if(!visited[i][j]) {
            	if (map[i][j] == 0)sb.append(0).append(" ");
            	else sb.append(-1).append(" ");
            }
            else sb.append(map[i][j]).append(" ");
        }
        sb.append("\n");
    }

    System.out.println(sb);
}
	
static void bfs(){
    while (!q.isEmpty()){
        Node node = q.poll();
        
    	for (int d=0;d<4;d++){
            int ny = node.y + dy[d];
            int nx = node.x + dx[d];

            if (ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] == 0 || visited[ny][nx]) continue;
            q.offer(new Node(ny,nx));
            map[ny][nx] = map[node.y][node.x] +1;
            visited[ny][nx] = true;
        }
        
    }

}

static class Node{
    int y,x;
    Node(int y, int x){
        this.y = y;
        this.x = x;
    }
}
}