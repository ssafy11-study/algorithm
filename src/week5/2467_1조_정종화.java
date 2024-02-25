// Subject: Study of Algorithm with SSAFY
// ProblemNo: 2467
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, v[], l, r, rx, ry, res;

    public static void main(String[] args) throws Exception{
        
        N = Integer.parseInt(br.readLine());
        v = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) v[i] = Integer.parseInt(st.nextToken());
        
        l = rx = 0; r = ry = N - 1;
        res = Math.abs(v[l] + v[r]);
        
        while(l < r){
            if(v[l] + v[r] == 0){
                System.out.println(v[l] + " " + v[r]);
                return;
            }
            if(Math.abs(v[l] + v[r]) < res){
                res = Math.abs(v[l] + v[r]);
                rx = l; ry = r;
            }
            if(v[l] + v[r] < 0) l++;
            else r--;
        }
        System.out.println(v[rx] + " " + v[ry]);
    }
}