import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		char[] bomb = br.readLine().toCharArray();

		int bombLen = bomb.length;

		List<Character> stack = new ArrayList<>();
		for (int i = 0; i < input.length; i++) {
			stack.add(input[i]);
			boolean valid = true;
			if (stack.size() >= bombLen) {
				for (int j = 0; j < bombLen; j++) {
					if (stack.get(stack.size() - bombLen + j) != bomb[j]) {
						valid = false;
						break;
					}
				}
				if (valid) {
					int size = stack.size();
					for (int j = size - 1; j > size - 1 - bombLen; j--) {
						stack.remove(j);
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		if (stack.isEmpty()) {
			sb.append("FRULA");
		} else {
			for(char c : stack) {
				sb.append(c);
			}
		}
		System.out.println(sb);
	}
}