// Subject: Study of Algorithm with SSAFY
// ProblemNo: 2798
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;


public class Main {

    static final int MX = 1000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, sum, res, v[];
    
    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        v = new int[N];
        for(int i = 0; i < N; i++) v[i] = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                for(int k = j + 1; k < N; k++){
                    sum = v[i] + v[j] + v[k];
                    if(sum <= M && M - res > M - sum) res = sum;
                }
            }
        }
        System.out.print(res);
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