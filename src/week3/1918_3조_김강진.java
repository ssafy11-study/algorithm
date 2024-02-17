import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] tmpEq = br.readLine().toCharArray();
        Deque<Character> op = new ArrayDeque<>();

        for(int i=0;i<tmpEq.length;i++){
            if (tmpEq[i] >='A' && tmpEq[i] <='Z') sb.append(tmpEq[i]);
            else {
                if (tmpEq[i] == '('){
                    op.push(tmpEq[i]);
                } else if (tmpEq[i] == '*' || tmpEq[i] == '/'){
                    while (!op.isEmpty() && (op.peek() == '*' || op.peek() == '/')){
                        sb.append(op.pop());
                    }
                    op.push(tmpEq[i]);
                } else if (tmpEq[i] == '+' || tmpEq[i] == '-'){
                    while (!op.isEmpty() && op.peek() != '('){
                        sb.append(op.pop());
                    }
                    op.push(tmpEq[i]);
                } else if (tmpEq[i] == ')'){
                    while (!op.isEmpty() && op.peek() != '('){
                        sb.append(op.pop());
                    }
                    op.pop();
                }
            }
        }

        while (!op.isEmpty()){
            sb.append(op.pop());
        }

        System.out.println(sb);
    }

}
