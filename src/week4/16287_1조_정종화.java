// Subject: Study of Algorithm with SSAFY
// ProblemNo: B16287
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    
    static class Pair{
        int x, y;
        Pair(int...a){
            this.x = a[0];
            this.y = a[1];
        }
        boolean isExclusive(int a, int b){
            return x != a && y != a && x != b && y != b;
        }
    }
    
    static final int BOUND = 400001;
    static final int MOD = 1000000009;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int w, n, v[];
    static boolean chk[] = new boolean[BOUND];
    static Pair p[] = new Pair[BOUND];
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        v = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) v[i] = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int now = v[i] + v[j];
                int rev = w - now;
                if(rev >= 0 && rev < BOUND && chk[rev]){
                    if(p[rev].isExclusive(i, j)){
                        System.out.print("YES");
                        return;
                    }
                }
                if(!chk[now]){
                    chk[now] = true;
                    p[now] = new Pair(i, j);
                }
            }
        }
        System.out.print("NO");
    }
}