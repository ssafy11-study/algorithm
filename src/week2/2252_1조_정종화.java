// Subject: Study of Algorithm with SSAFY
// ProblemNo: 2252
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

	static final int MX = 10000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
	static ArrayList<Integer> []gph;
	static Deque<Integer> q = new ArrayDeque<>();
	static int N, M, x, y, cnt[];
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        cnt = new int[N];
        gph = new ArrayList[N];
        for(int i = 0; i < N; i++) gph[i] = new ArrayList();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()); x--;
            y = Integer.parseInt(st.nextToken()); y--;
            gph[x].add(y); cnt[y]++;
        }
        for(int i = 0; i < N; i++) if(cnt[i] == 0) q.addLast(i);
        
        while(!q.isEmpty()){
            int now = q.remove();
            System.out.print((now + 1) + " ");
            for(int tar : gph[now]){
                cnt[tar]--;
                if(cnt[tar] == 0) q.addLast(tar);
            }
        }
    }
}