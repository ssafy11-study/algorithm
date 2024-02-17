// Subject: Study of Algorithm with SSAFY
// ProblemNo: 1546
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;


public class Main {

    static final int MX = 1000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static int N;
    static double total, M;
    
    //Integer.parseInt(br.readLine());
    //StringTokenizer st = new StringTokenizer(br.readLine());
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            total += x;
            M = Math.max(M, x);
        }
        System.out.println(total / N / M * 100);
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