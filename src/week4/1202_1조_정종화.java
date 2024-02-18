// Subject: Study of Algorithm with SSAFY
// ProblemNo: B1202
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    
    static class Cristal{
        int m, v;
        Cristal(int...a){
            this.m = a[0];
            this.v = a[1];
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, K, x, y, bag[];
    static long res;
    static Cristal cristal[];
    static PriorityQueue<Cristal> pq = new PriorityQueue<>((o1, o2)->o2.v - o1.v);
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cristal = new Cristal[N];
        bag = new int[K];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            cristal[i] = new Cristal(x, y);
        }
        for(int i = 0; i < K; i++) bag[i] = Integer.parseInt(br.readLine());
        Arrays.sort(cristal, (o1, o2) -> o1.m - o2.m);
        Arrays.sort(bag);
        
        int idx = 0;
        for(int i = 0; i < K; i++){
            while(idx < N && cristal[idx].m <= bag[i]) pq.add(cristal[idx++]);
            if(!pq.isEmpty()){
                Cristal now = pq.remove();
                res += now.v;
            }
        }
        System.out.print(res);
        
    }
}