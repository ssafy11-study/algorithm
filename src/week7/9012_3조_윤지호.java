import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static Deque<Character> stack = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            boolean valid = true;
            char[] inputs = br.readLine().toCharArray();
            stack.clear();
            for (int j = 0; j < inputs.length; j++) {
                if (inputs[j] == '(') {
                    stack.push('(');
                } else {
                    if (stack.isEmpty()) {
                        valid = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if(!stack.isEmpty()) {
                valid = false;
            }
            sb.append(valid ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }
}