// Subject: Study of Algorithm with SSAFY
// ProblemNo: 10845
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static class CustomQueue{
        Deque<Integer> queue = new ArrayDeque<>();
        void push(int x){ queue.offer(x); }
        int pop(){ return queue.isEmpty()? -1 : queue.remove(); }
        int empty() { return queue.isEmpty()? 1 : 0; }
        int size(){ return queue.size(); }
        int front() { return queue.isEmpty()? -1 : queue.getFirst(); }
        int back() { return queue.isEmpty()? -1 : queue.getLast(); }
    }

	static final int MX = 10001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, x;
    static String order;
    static CustomQueue cq = new CustomQueue();
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine());
            order = st.nextToken();
            if(order.equals("push")){
                x = Integer.parseInt(st.nextToken());
                cq.push(x);
            }
            if(order.equals("pop")) sb.append(cq.pop() + "\n");
            if(order.equals("size")) sb.append(cq.size() + "\n");
            if(order.equals("empty")) sb.append(cq.empty() + "\n");
            if(order.equals("front")) sb.append(cq.front() + "\n");
            if(order.equals("back")) sb.append(cq.back() + "\n");
        }
        System.out.println(sb);
    }
}
