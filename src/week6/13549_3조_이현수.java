import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _13549_3조_이현수 {
    static int N, K;
    static int[] dis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수빈이 위치
        K = Integer.parseInt(st.nextToken()); // 동생 위치

        dis = new int[200_001];
        Arrays.fill(dis, 100001);

        dis[N] = 0;
        BFS(N);
        System.out.print(dis[K]);
    }

    static void BFS(int N){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(N);
        while(!q.isEmpty()){
            int temp = q.pollFirst();
            if(temp == K) return;

            int teleport = temp * 2;
            if(teleport <= 100_000 && dis[teleport] > dis[temp]){
                dis[teleport] = dis[temp];
                q.addFirst(teleport);
            }

            int sub = temp - 1;
            int sum = temp + 1;

            if(sub >= 0 && dis[sub] > dis[temp] + 1){
                dis[sub] = dis[temp] + 1;
                q.addLast(sub);
            }

            if(sum <= 100_000 && dis[sum] > dis[temp] + 1){
                dis[sum] = dis[temp] + 1;
                q.addLast(sum);
            }
        }
    }
}
