// Subject: Study of Algorithm with SSAFY
// ProblemNo: 1697
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static int next(int now, int idx){
        if(idx == 0 && now > 0) return now - 1;
        if(idx == 1 && now < MX - 1) return now + 1;
        if(idx == 2 && now * 2 < MX) return now * 2;
        return now;
    }

    static final int MX = 100001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, K, vtd[];
    static ArrayDeque<Integer> q = new ArrayDeque();
    
    public static void main(String[] args) throws Exception{
        vtd = new int[MX];
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        vtd[N] = 1;
        q.offer(N);
        while(!q.isEmpty()){
            int now = q.poll();
            if(now == K){
                System.out.println(vtd[now] - 1);
                return;
            }
            for(int i = 0; i < 3; i++){
                int tar = next(now, i);
                if(vtd[tar] == 0){
                    vtd[tar] = vtd[now] + 1;
                    q.offer(tar);
                }
            }
        }
        
    }
}