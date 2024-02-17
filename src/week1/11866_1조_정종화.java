// Subject: Study of Algorithm with SSAFY
// ProblemNo: 11866
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;


public class Main {

    static final int MX = 1000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K, res, cnt, idx;
    static boolean chk[];
    
    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        res = 0; idx = -1; cnt = 0;
        chk = new boolean[N];
        System.out.print("<");
        while(res < N){
            idx = (idx + 1) % N;
            if(chk[idx]) continue;
            cnt++;
            if(cnt == K){
                System.out.print(idx + 1);
                chk[idx] = true;
                if(++res != N) System.out.print(", ");
                cnt = 0;
            }
            
        }
        System.out.print(">");
    }
    
    public void reference_sysio() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer.parseInt(st.nextToken());
        System.out.println("");
    }
    
    public void reference_mathematic_symbols(){
        int M = Math.max(1, 2);
    }
}