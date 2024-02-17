import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static Stack<Integer> stack;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        stack = new Stack<>();
        stack.add(0);
        backtracking();
    }

    public static void backtracking() {
        if (stack.size() == m+1) {
            for(int i:stack) {
                if (i==0) {
                    continue;
                }
                System.out.print(i+" ");
            }
            System.out.println("");
            return;
        }

        for(int i = 1; i<=n; i++) {
            if (!stack.contains(i) && i>stack.peek()) {
                stack.add(i);
                backtracking();
                stack.pop();
            }
        }
    }
}