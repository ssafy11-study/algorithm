// Subject: Study of Algorithm with SSAFY
// ProblemNo: 17387
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static class Pos{
        long x, y;
        Pos(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
    
    static long ccw(Pos a, Pos b, Pos c){
        long flag = a.x * b.y + b.x * c.y + c.x * a.y - a.y * b.x - b.y * c.x - c.y * a.x;
        if(flag > 0) return 1;
        if(flag < 0) return -1;
        return 0;
    }

    static boolean isIn(Pos a, Pos b, Pos c){
        return (Math.abs(c.x - a.x) + Math.abs(c.x - b.x) == Math.abs(a.x - b.x)) && (Math.abs(c.y - a.y) + Math.abs(c.y - b.y) == Math.abs(a.y - b.y));
    }
    
    static boolean solve(){
        long FLAG1 = ccw(p1, p2, p3) * ccw(p1, p2, p4);
        long FLAG2 = ccw(p3, p4, p1) * ccw(p3, p4, p2);
        if(FLAG1 < 0 && FLAG2 < 0) return true;
        if(ccw(p1, p2, p3) == 0 && isIn(p1, p2, p3)) return true;
        if(ccw(p1, p2, p4) == 0 && isIn(p1, p2, p4)) return true;
        if(ccw(p3, p4, p1) == 0 && isIn(p3, p4, p1)) return true;
        if(ccw(p3, p4, p2) == 0 && isIn(p3, p4, p2)) return true;
        return false;
    }
    
	static final int MX = 10001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Pos p1, p2, p3, p4;
    static long v[] = new long[4];
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) v[i] = Integer.parseInt(st.nextToken());
        p1 = new Pos(v[0], v[1]); p2 = new Pos(v[2], v[3]);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) v[i] = Integer.parseInt(st.nextToken());
        p3 = new Pos(v[0], v[1]); p4 = new Pos(v[2], v[3]);
        System.out.println(solve()? 1 : 0);
    }
}
