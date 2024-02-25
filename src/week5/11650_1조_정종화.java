// Subject: Study of Algorithm with SSAFY
// ProblemNo: 11650
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static class Pos{
        int x, y;
        Pos(int ...a){
            this.x = a[0]; this.y = a[1];
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static Pos p[];
    static int N, x, y;
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        p = new Pos[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            p[i] = new Pos(x, y);
        }
        Arrays.sort(p, (o1, o2) -> o1.x == o2.x? o1.y - o2.y : o1.x - o2.x);
        for(Pos now : p) sb.append(now.x + " " + now.y).append('\n');
        System.out.println(sb);
    }
}