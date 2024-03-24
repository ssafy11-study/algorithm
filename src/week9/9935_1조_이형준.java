import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bomb = br.readLine();
		Stack<Character> stack = new Stack<>();
		char[] temp = new char[bomb.length()];
		char[] result;
		boolean flag = false;

		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));

			if (bomb.charAt(bomb.length() - 1) == stack.peek() && stack.size() >= bomb.length()) {
				for (int j = 0; j < bomb.length(); j++) {
					if (stack.get(stack.size() - bomb.length()+j) == bomb.charAt(j)) {
						flag = true;
					} else {
						flag = false;
						break;
					}
				}
				if (flag == true) {
					for (int j = 0; j < bomb.length(); j++) {
						stack.pop();
					}
				}
			}
		}

		result = new char[stack.size()];

		StringBuilder sb = new StringBuilder();
		
		
		if (stack.size() == 0) System.out.println("FRULA");
		else {
			for (int i = 0; i < stack.size(); i++) {
				sb.append(stack.get(i));
			}
		}
		
		System.out.println(sb);
		
		


		}

	}