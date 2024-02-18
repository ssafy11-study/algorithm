import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[] src, tgt;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static void search(int depth){
        if(depth == M){
            for(int i = 0; i < M; i++){
                sb.append(tgt[i]).append(' ');
            }
            sb.append('\n');
            return ;
        }
        int num = 0;
        for(int i = 0; i < N; i++){
            if(visited[i] || num == src[i]) continue;
            visited[i] = true;
            tgt[depth] = src[i];
            num = src[i];
            search(depth + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        src = new int[N];
        tgt = new int[M];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            src[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(src);
        search(0);
        System.out.println(sb);
    }
}
