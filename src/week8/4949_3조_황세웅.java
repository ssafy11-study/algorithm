import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static boolean ans;
	static Deque<Character> stack;

	public static void main(String[] args) throws IOException {
		while (true) {
			String input = br.readLine();
			if (input.equals(".")) break;
			
			ans = true;
			stack = new ArrayDeque<>();
			
			for (int i = 0; i < input.length() - 1; i++) {
				char c = input.charAt(i);
				if (c == '(') stack.push('(');
				else if (c == ')') {
					if (stack.isEmpty()) ans = false;
					else if (stack.pop() != '(') ans = false;
				}
				else if (c == '[') stack.push('[');
				else if (c == ']') {
					if (stack.isEmpty()) ans = false;
					else if (stack.pop() != '[') ans = false;
				}
				if (!ans) break;
			}
			if (!stack.isEmpty()) ans = false;
			sb.append(ans ? "yes" : "no").append("\n");
		}
		System.out.print(sb);
	}
}