// Subject: Study of Algorithm with SSAFY
// ProblemNo: B9012
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static boolean simulate(String p){
        int cnt = 0;
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '(') cnt++;
            else cnt--;
            if(cnt < 0) return false;
        }
        return cnt == 0;
    }

    static final int MX = 100101;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T;
    static String s;
    
    public static void main(String[] args) throws Exception{
        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            s = br.readLine();
            sb.append(simulate(s)? "YES\n" : "NO\n");
        }
        System.out.print(sb);
    }
}