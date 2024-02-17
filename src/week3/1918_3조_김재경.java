import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static char[] formula;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        formula = br.readLine().toCharArray();
        int p = -1;
//        int isBracket = 0;

        Deque<Character> stack = new ArrayDeque<>();
        while (++p < formula.length) {
            char now = formula[p];

            //알파벳이면 먼저 append
            if (isOperand(now)) {
                sb.append(now);
                continue;
            }
            //stack이 비어있으면 push
            if (stack.isEmpty()) {
                stack.push(now);
                continue;
            }
            char pre = stack.peek();
            if(pre=='(' && now !=')') {
                stack.push(now);
                continue;
            }
            //닫는 괄호를 만났다면, 여는 괄호를 만날 때 까지 pop
            if(now==')'){
                while(!stack.isEmpty()){
                    pre = stack.peek();
                    if(stack.peek()=='(') {
                        break;
                    }
                    sb.append(stack.pop());
                }
                stack.pop(); // '(' 수거

                continue;
            }

            //now가 stack.peek 의 우선순위보다 같거나 낮으면, 높은 연산자를 만날 때 까지 pop
            if(priority(pre) >= priority(now)){
                while(!stack.isEmpty()) {
                    pre = stack.peek();
                    if(priority(pre) >= priority(now)){
                        if(pre=='(') break;
                        sb.append(stack.pop());
                    }else break;

                }
            }
            if(now!=')')  stack.push(now);
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());

    }
    static boolean isOperand(char c) {
        if (priority(c) == -1)
            return true;
        else
            return false;
    }

    static int priority(char c) {
        if (c == '(' || c == ')')
            return 2;

        if (c == '*' || c == '/')
            return 1;

        if (c == '+' || c == '-')
            return 0;

        return -1;

    }
}

