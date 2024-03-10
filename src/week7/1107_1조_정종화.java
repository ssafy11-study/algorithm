// Subject: Study of Algorithm with SSAFY
// ProblemNo: B1107
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {


    static int isMovable(int N){
        if(N == 0) return isBroken[0]? -1 : 1;
        int ret = 0;
        while(N > 0){
            if(isBroken[N % 10]) return -1;
            N /= 10; ret++;
        }
        return ret;
    }

    static int bruteForce(){
        int ret = Math.abs(100 - N);
        for(int i = 0; i < MX; i++){
            if(i == 100) continue;
            int ans = isMovable(i);
            if(ans != -1) ret = Math.min(ret, Math.abs(i - N) + ans);
        }
        return ret;
    }

    static final int MX = 999999;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, x;
    static boolean isBroken[];
   
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        isBroken = new boolean[10];
        
        if(M > 0) st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) isBroken[Integer.parseInt(st.nextToken())] = true;
        System.out.println(bruteForce());
        
    }
}