// Subject: Study of Algorithm with SSAFY
// ProblemNo: B10866
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    
    static void push_front(int x){ dq.addFirst(x); }
    static void push_back(int x){ dq.addLast(x); }
    static int pop_front(){
        if(dq.isEmpty()) return -1;
        return dq.removeFirst();        
    }
    static int pop_back(){
        if(dq.isEmpty()) return -1;
        return dq.removeLast(); 
    }    
    static int size(){ return dq.size(); }
    static int empty(){ return (dq.isEmpty()? 1 : 0); }
    static int front(){
        if(dq.isEmpty()) return -1;
        return dq.getFirst();
    }
    static int back(){
        if(dq.isEmpty()) return -1;
        return dq.getLast();
    }


	static final int MX = 10001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayDeque<Integer> dq = new ArrayDeque();
    static String s;
    static int N, x;
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine());
            s = st.nextToken();
            if(s.equals("push_front")){
                x = Integer.parseInt(st.nextToken());
                push_front(x);
            }
            if(s.equals("push_back")){
                x = Integer.parseInt(st.nextToken());
                push_back(x);
            }
            if(s.equals("pop_front")) sb.append(pop_front()).append('\n');
            if(s.equals("pop_back")) sb.append(pop_back()).append('\n');
            if(s.equals("size")) sb.append(size()).append('\n');
            if(s.equals("empty")) sb.append(empty()).append('\n');
            if(s.equals("front")) sb.append(front()).append('\n');
            if(s.equals("back")) sb.append(back()).append('\n');
        }
        System.out.print(sb);
    }
}
