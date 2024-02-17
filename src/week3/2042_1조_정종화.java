// Subject: Study of Algorithm with SSAFY
// ProblemNo: 2042
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    
    static void init(int idx, int l, int r){
        if(l == r){
            tree[idx] = v[l];
            rev[l] = idx;
            return;
        }
        int mid = (l + r) / 2;
        init(2 * idx, l, mid);
        init(2 * idx + 1, mid + 1, r);
        tree[idx] = tree[2 * idx] + tree[2 * idx + 1];
    }
    
    static void update(int idx, long key){ 
        long diff = key - tree[idx];
        while(idx > 0) { tree[idx] += diff; idx /= 2; }
    }
    static long query(int idx, int l, int r, int s, int e){
        if(s <= l && r <= e) return tree[idx];
        if(s > r || l > e) return 0;
        int mid = (l + r) / 2;
        return query(2 * idx, l, mid, s, e) + query(2 * idx + 1, mid + 1, r, s, e);
    }

	static final int MX = 10001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static long v[], tree[], a, b, c;
    static int N, M, K, rev[];
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        v = new long[N + 1]; tree = new long[4 * (N + 1)]; rev = new int[N + 1];
        for(int i = 1; i <= N; i++) v[i] = Long.parseLong(br.readLine()); 
        init(1, 1, N);
        for(int i = 0; i < M + K; i++){
            st = new StringTokenizer(br.readLine());
            a = Long.parseLong(st.nextToken());
            b = Long.parseLong(st.nextToken());
            c = Long.parseLong(st.nextToken());
            if(a == 1) update(rev[(int)b], c);
            else sb.append(query(1, 1, N, (int)b, (int)c)).append('\n');
        }
        System.out.println(sb);
    }
}
