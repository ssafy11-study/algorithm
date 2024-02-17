import java.io.*;
import java.util.*;


class Operator{
    char op;
    int prior;
    Operator(char op, int prior){
        this.op = op;
        this.prior = prior;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Operator> stack = new ArrayDeque<>();

        char[] chars = br.readLine().toCharArray();
        char c;
        for(int i = 0; i < chars.length; i++) {
            c= chars[i];
            if(c >= 'A') sb.append(c);
            else if(c == '+') {
                while(!stack.isEmpty() && stack.peek().prior >= 1) sb.append(stack.pop().op);
                stack.push(new Operator('+', 1));
            }
            else if(c == '-') {
                while(!stack.isEmpty() && stack.peek().prior >= 1) {
                    sb.append(stack.pop().op);
                }
                stack.push(new Operator('-', 1));
            }
            else if(c == '*') {
                while(!stack.isEmpty() && stack.peek().prior >= 2) sb.append(stack.pop().op);
                stack.push(new Operator('*', 2));
            }
            else if(c == '/') {
                while(!stack.isEmpty() && stack.peek().prior >= 2) {

                    sb.append(stack.pop().op);
                }
                stack.push(new Operator('/', 2));
            }
            else if(c == '(') {
                stack.push(new Operator('(', 0));
            }
            else if(c == ')') {
                while(stack.peek().op != '(') {
                    sb.append(stack.pop().op);
                }
                stack.pop();
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop().op);
        }
        System.out.println(sb);
    }
}
