package SSAFY.study.week8.t4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static String s, answer;
    static Deque<Character> stack = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            s = br.readLine();
            if (s.equals(".")) {
                break;
            }
            answer = "yes";
            stack.clear();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                switch (c) {
                    case '[':
                    case '(':
                        stack.push(c);
                        break;
                    case ']':
                        if(stack.isEmpty() || stack.peekFirst() != '[') {
                            answer = "no";
                        }
                        else stack.pop();
                        break;
                    case ')':
                        if(stack.isEmpty() || stack.peekFirst() != '(') {
                            answer = "no";
                        }
                        else stack.pop();
                        break;
                    default:
                        break;
                }
                if(answer.equals("no")) break;
            }
            if(!stack.isEmpty()) answer = "no";
//            sb.append(s).append("\n");
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
