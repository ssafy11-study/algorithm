// Subject: Study of Algorithm with SSAFY
// ProblemNo: B10828
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static class MyStack{
        ArrayDeque<Integer> stack;
        MyStack(){
            stack = new ArrayDeque();
        }
        void push(int x) { stack.push(x); }
        int pop(){
            if(stack.isEmpty()) return -1;
            return stack.pop();
        }
        int size() { return stack.size(); }
        int empty() { return stack.isEmpty()? 1 : 0; }
        int top() {
            if(stack.isEmpty()) return -1;
            return stack.peek();
        }
    }

    static final int MX = 100101;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T, x;
    static String order;
    static MyStack ms = new MyStack();
    
    public static void main(String[] args) throws Exception{
        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            order = st.nextToken();
            if(order.equals("push")){
                x = Integer.parseInt(st.nextToken());
                ms.push(x);
            }
            if(order.equals("pop")) sb.append(ms.pop()).append('\n');
            if(order.equals("size")) sb.append(ms.size()).append('\n');
            if(order.equals("empty")) sb.append(ms.empty()).append('\n');
            if(order.equals("top")) sb.append(ms.top()).append('\n');
        }
        System.out.print(sb);
    }
}