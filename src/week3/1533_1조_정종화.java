// Subject: Study of Algorithm with SSAFY
// ProblemNo: 1533
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    
    static void connect(int x, int y, int d){
        if(d == 0) return;
        for(int i = 0; i < d; i++){
            if(i == d - 1) v[x + i][y] = 1;
            else v[x + i][x + i + 1] = 1;
        }
    }

	static final int MX = 10001;
	static final int MOD = 1000003;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, SZ, S, E, T;
    static long v[][], w[][], res[][];
    static String s;
    
    static void mul(long tar[][], long a[][], long b[][]){
        long ret[][] = new long[SZ][SZ];
        
        for(int i = 0; i < SZ; i++){
            for(int j = 0; j < SZ; j++){
                for(int k = 0; k < SZ; k++){
                    ret[i][j] = (ret[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }
        for(int i = 0; i < SZ; i++) for(int j = 0; j < SZ; j++) tar[i][j] = ret[i][j];
        return;
    }
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken()); S--;
        E = Integer.parseInt(st.nextToken()); E--;
        T = Integer.parseInt(st.nextToken());
        
        SZ = 5 * N;
        v = new long[SZ][SZ];
        w = new long[SZ][SZ];
        res = new long[SZ][SZ];
        
        for(int i = 0; i < N; i++){
            s = br.readLine();
            for(int j = 0; j < N; j++) connect(5 * i, 5 * j, s.charAt(j) - '0');
        }
        
        for(int i = 0; i < SZ; i++) res[i][i] = 1;
        while(T > 0){
            if(T % 2 == 1) mul(res, res, v);
            T /= 2;
            mul(v, v, v);

        }
        System.out.println(res[5 * S][5 * E]);
    }
}
