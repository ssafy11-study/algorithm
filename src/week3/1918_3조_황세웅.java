import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static Deque<Character> ans = new ArrayDeque<>();
	static Deque<Character> operator = new ArrayDeque<>();
	
	static final Map<Character, Integer> priority = new HashMap<>();
	static {
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('(', 0);
		priority.put(')', 0);
	}

	public static void main(String[] args) throws IOException {
		char[] input = br.readLine().toCharArray();
		for (char c : input) {
			if (priority.containsKey(c)) {
				if (c == '(') {
					operator.push(c);
					continue;
				}
				if (c == ')') {
					while (!operator.isEmpty()) {
						char poped = operator.pop();
						if (poped == '(') {
							break;
						}
						ans.push(poped);
					}
					continue;
				}
				while (!operator.isEmpty()) {
					if (priority.get(c) > priority.get(operator.peek())) {
						break;
					}
					ans.push(operator.pop());
				}
				operator.push(c);
				continue;
			}
			ans.push(c);
		}
		
		while (!operator.isEmpty()) {
			ans.push(operator.pop());
		}
		
		StringBuilder sb = new StringBuilder();
		while (!ans.isEmpty()) {
			sb.append(ans.pollLast());
		}
		System.out.println(sb);
	}
}
