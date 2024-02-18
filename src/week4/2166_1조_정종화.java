// Subject: Study of Algorithm with SSAFY
// ProblemNo: B2166
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    
    static class Pos{
        long x, y;
        Pos(int...a){
            this.x = (long)a[0];
            this.y = (long)a[1];
        }
        long cal(Pos tar){ return this.x * tar.y - this.y * tar.x; }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, x, y;
    static long res;
    static Pos v[];
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        v = new Pos[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            v[i] = new Pos(x, y);
        }
        for(int i = 0; i < N; i++) res += v[i].cal(v[(i + 1) % N]);
        System.out.print(Math.abs(res / 2));
        System.out.printf(".%d",(res % 2 == 1)? 5 : 0);
    }
}