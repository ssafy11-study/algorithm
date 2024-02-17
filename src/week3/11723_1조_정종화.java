// Subject: Study of Algorithm with SSAFY
// ProblemNo: 11723
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static class CustomSet{
        HashSet<Integer> set = new HashSet<>();
        
        void add(int x){ set.add(x); }
        void remove(int x){ set.remove(x); }
        int check(int x){ return set.contains(x)? 1 : 0; }
        void toggle(int x){ if(set.contains(x)) set.remove(x); else set.add(x); }
        void all(){ for(int i = 1; i <= 20; i++) set.add(i); }
        void empty(){ set.clear(); }
    }

	static final int MX = 10001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, x;
    static String order;
    static CustomSet cs = new CustomSet();
    
    public static void main(String[] args) throws Exception{
        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
   
            order = st.nextToken();
            try{ x = Integer.parseInt(st.nextToken()); }
            catch(Exception e) { x = -1; }
            
            if(order.equals("add")) cs.add(x);
            if(order.equals("remove")) cs.remove(x);
            if(order.equals("check")) sb.append(cs.check(x) + "\n");
            if(order.equals("toggle")) cs.toggle(x);
            if(order.equals("all")) cs.all();
            if(order.equals("empty")) cs.empty();
        }
        System.out.println(sb);
    }
}
