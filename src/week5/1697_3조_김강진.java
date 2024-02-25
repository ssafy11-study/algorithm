import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,K,cnt;
    static boolean[] visited = new boolean[100001];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K){
            System.out.println(0);
            return;
        }
        cnt = 0;
        visited[N] = true;
        bfs(N);

    }

    static void bfs(int n){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);

        while(true){
            cnt++;
            int size = q.size();

            visited[n] = true;
           for (int i=0;i<size;i++){
               int x = q.poll();
               if (x-1 == K || x+1 == K || 2*x == K){
                   System.out.println(cnt);
                   return;
               }
               if (x - 1 >= 0 && ! visited[x-1]){
                   visited[x-1] = true;
                   q.offer(x-1);
               }
               if (x+1 <= 100000 && !visited[x+1]){
                   visited[x+1] = true;
                   q.offer(x+1);
               }
               if( 2*x <= 100000 && !visited[2*x]){
                   visited[2*x] = true;
                   q.offer(2*x);
               }
           }
        }
    }
}