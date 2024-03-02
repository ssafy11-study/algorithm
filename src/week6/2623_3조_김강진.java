import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.StringTokenizer;
import java.util.*;

// 위상정렬?
public class Main {
    static int N,M;
    static int[] singer;
    static boolean done=true;
    static List<List<Integer>> adj = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        singer = new int[N+1]; // 진출차수 관리할 배열
        for(int i=0;i<=N;i++){
            adj.add(new ArrayList<>());
        }

        for (int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int sing = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            for(int s=1;s<sing;s++){
                int next = Integer.parseInt(st.nextToken());
                adj.get(prev).add(next);
                prev = next;
                singer[next]++;
            }
        }
        tops();

        for (int i=1;i<=N;i++){
            if (singer[i] != 0){
                done = false;
                break;
            }
        }
        System.out.println(done?sb:0);
    }

    static void tops(){
        Queue<Integer> q = new ArrayDeque<>();
        for (int i=1;i<=N;i++){
            if(singer[i]==0) q.offer(i);
        }
        int size = 0;
        while(!q.isEmpty()){
            size = q.size();
            for(int i =0;i<size;i++){
                int tmp = q.poll();
                sb.append(tmp).append("\n");
                for(int t: adj.get(tmp)){
                    singer[t]-=1;
                    if (singer[t] == 0){
                        q.offer(t);
                    }
                }
            }
        }
    }
}
