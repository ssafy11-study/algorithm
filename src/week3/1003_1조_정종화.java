// Subject: Study of Algorithm with SSAFY
// ProblemNo: 1003
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

	static final int MX = 10001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, x, v[][];
    
    public static void main(String[] args) throws Exception{
        T = Integer.parseInt(br.readLine());
        v = new int[41][2];
        v[0][0] = v[1][1] = 1;
        for(int i = 2; i <= 40; i++){
            v[i][0] = v[i - 1][0] + v[i - 2][0];
            v[i][1] = v[i - 1][1] + v[i - 2][1];
        }
        for(int t = 0; t < T; t++){
            x = Integer.parseInt(br.readLine());
            System.out.println(v[x][0] + " " + v[x][1]);
        }
    }
}
