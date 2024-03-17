import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			char[] input = br.readLine().toCharArray();

			if (input.length == 1) {
				if (input[0] == '.') {
					break;
				}
			}

			boolean valid = true;
			Deque<Character> stack = new ArrayDeque<>();
			for (char c : input) {
				if (c == '(' || c == '[') {
					stack.push(c);
				} else if (c == ']' || c == ')') {
					if (stack.isEmpty()) {
						valid = false;
						break;
					}
					char temp = stack.pop();
					if (c == ']') {
						if (temp != '[') {
							valid = false;
							break;
						}
					} else if (c == ')') {
						if (temp != '(') {
							valid = false;
							break;
						}
					}

				}
			}
			if (!stack.isEmpty()) {
				valid = false;
			}
			if (valid) {
				sb.append("yes");
			} else {
				sb.append("no");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}