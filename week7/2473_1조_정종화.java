// Subject: Study of Algorithm with SSAFY
// ProblemNo: B2473
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {

    static long f(int...a) { return v[a[0]] + v[a[1]] + v[a[2]]; }

    static class Result{
        int i, j, k;
        long val;
        Result(int ...a){
            this.i = a[0];
            this.j = a[1];
            this.k = a[2];
            val = Math.abs(f(a));
        }
    }

    static final int MX = 999999;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, l, r;
    static long v[];
    static Result res;
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        v = new long[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) v[i] = Long.parseLong(st.nextToken());
        Arrays.sort(v);
        
        res = new Result(0, 1, 2);
        for(int i = 0; i < N; i++){
            l = i + 1; r = N - 1;
            while(l < r){
                long query = f(i, l, r);
                if(Math.abs(query) < res.val) res = new Result(i, l, r);
                if(query <= 0) l++;
                else r--;
            }
        }
        System.out.print(v[res.i] + " " + v[res.j] + " " + v[res.k]);
        
    }
}