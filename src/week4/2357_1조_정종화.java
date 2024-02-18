// Subject: Study of Algorithm with SSAFY
// ProblemNo: B2357
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    
    static class Info{
        int min, max;
        Info(int...a){
            this.min = a[0];
            this.max = a[1];
        }
    }
    
    static void init(int idx, int l, int r){
        if(l == r){
            tree[idx] = new Info(val[l], val[l]);
            return;
        }
        int mid = (l + r) / 2;
        init(2 * idx, l, mid);
        init(2 * idx + 1, mid + 1, r);
        tree[idx] = new Info(Math.min(tree[2 * idx].min, tree[2 * idx + 1].min), Math.max(tree[2 * idx].max, tree[2 * idx + 1].max));
    }
    
    static Info query(int idx, int l, int r, int s, int e){
        if(s <= l && r <= e) return tree[idx];
        if(s > r || l > e) return new Info(INIT_MIN, INIT_MAX);
        int mid = (l + r) / 2;
        Info left = query(2 * idx, l, mid, s, e);
        Info right = query(2 * idx + 1, mid + 1, r, s, e);
        return new Info(Math.min(left.min, right.min), Math.max(left.max, right.max));
    }
    
    
    static final int INIT_MIN = 1000000001;
    static final int INIT_MAX = 0;
    static final int MOD = 1000000009;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, x, y, val[];
    static Info tree[];
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        val = new int[N];
        for(int i = 0; i < N; i++) val[i] = Integer.parseInt(br.readLine());
        tree = new Info[4 * N + 4];
        init(1, 0, N - 1);
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()); x--;
            y = Integer.parseInt(st.nextToken()); y--;
            Info res = query(1, 0, N - 1, x, y);
            sb.append(res.min).append(' ').append(res.max).append('\n');
        }
        System.out.print(sb);
    }
}