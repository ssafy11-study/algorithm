
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T,N,K,W;
    static int[] D,P, ans;

    static List<List<Integer>> list;
    static StringBuilder sb=  new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            list = new ArrayList<>();
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            D = new int[N+1];
            P = new int[N+1];

            st = new StringTokenizer(br.readLine());
            // 시간 입력
            for (int n =0;n<=N;n++){
                list.add(new ArrayList<>());
                if (n !=0) D[n] = Integer.parseInt(st.nextToken());
            }
            // 건물 순서 입력
            for (int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int prev = Integer.parseInt(st.nextToken());
                int next = Integer.parseInt(st.nextToken());

                list.get(prev).add(next);
                P[next] += 1;
            }

            W = Integer.parseInt(br.readLine());
            tops();

        }
        System.out.println(sb);
    }

    static void tops(){
        Queue<Integer> q = new ArrayDeque<>();
        ans = new int[N+1];

        for(int i=1;i<=N;i++){
            ans[i] =D[i];
            if(P[i]==0) q.offer(i);
        }

        while(!q.isEmpty()){
            int tmp = q.poll();
            for (int next : list.get(tmp)){
                ans[next] = Math.max(ans[next], ans[tmp] +D[next]); // 현재 단계 건물과, 이전단계 + 현재 건물 생산시간 비교 하여 더 큰것 기록
                P[next]--;
                if(P[next]==0){
                    q.add(next);
                }
            }
        }
        sb.append(ans[W]).append("\n");
    }
}
