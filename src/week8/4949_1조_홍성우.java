import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while (true) {
            line = br.readLine();
            if (line.equals(".")) break;

            System.out.println(isBalanced(line) ? "yes" : "no");
        }
    }

    public static boolean isBalanced(String s) {
        ArrayDeque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            
            if (c == '(' || c == '[') {
                deque.push(c);
            }
            
            else if (c == ')') {
                if (deque.isEmpty() || deque.pop() != '(') {
                    return false;
                }
            }
            else if (c == ']') {
                if (deque.isEmpty() || deque.pop() != '[') {
                    return false;
                }
            }
        }

        return deque.isEmpty(); 
    }
}
