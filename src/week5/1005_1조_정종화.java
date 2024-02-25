// Subject: Study of Algorithm with SSAFY
// ProblemNo: 1005
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T, N, K, E, x, y, build[], cnt[], total[];
    static ArrayList<Integer> gph[];
    static ArrayDeque<Integer> queue = new ArrayDeque();
    
    public static void main(String[] args) throws Exception{
        
        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            build = new int[N]; cnt = new int[N]; total = new int[N];
            gph = new ArrayList[N];
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                gph[i] = new ArrayList();
                build[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken()); x--;
                y = Integer.parseInt(st.nextToken()); y--;
                gph[x].add(y); cnt[y]++;
            }
            for(int i = 0; i < N; i++) if(cnt[i] == 0) queue.offer(i);
            while(!queue.isEmpty()){
                int now = queue.poll();
                for(int next : gph[now]){
                    total[next] = Math.max(total[next], total[now] + build[now]);
                    cnt[next]--;
                    if(cnt[next] == 0) queue.offer(next);
                }
            }
            E = Integer.parseInt(br.readLine()); E--;
            sb.append(total[E] + build[E]).append('\n');
        }
        System.out.print(sb);
    }
}