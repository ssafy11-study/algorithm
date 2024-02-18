// Subject: Study of Algorithm with SSAFY
// ProblemNo: B1725
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    
    static class Info{
        int val, idx;
        Info(int...a){
            this.val = a[0];
            this.idx = a[1];
        }
    }
    
    static final int MOD = 1000000009;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, now, ptr, chk;
    static Info v[];
    static long res;
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        v = new Info[N + 1];
        v[ptr] = new Info(-1, -1); ptr++;
        for(int i = 0; i < N; i++){
            now = Integer.parseInt(br.readLine()); chk = i;
            while(v[ptr - 1].val > now) {
                res = Math.max(res, (long)v[ptr - 1].val * (i - v[ptr - 1].idx));
                chk = v[ptr - 1].idx; ptr--;
            }
            v[ptr] = new Info(now, chk); ptr++;
        }
        while(ptr > 1){
            res = Math.max(res, (long)v[ptr - 1].val * (N - v[ptr - 1].idx));
            chk = v[ptr - 1].idx; ptr--;
        }
        System.out.print(res);
    }
}