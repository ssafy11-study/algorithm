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
	
	static int N;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		Deque<Integer> stack = new ArrayDeque<>();
		
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()){
			case "push":
				int n = Integer.parseInt(st.nextToken());
				stack.push(n);
				break;
			case "pop":
				sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
				break;
			case "size":
				sb.append(stack.size()).append("\n");
				break;
			case "empty":
				sb.append(stack.isEmpty() ? 1 : 0).append("\n");
				break;
			case "top":
				sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
				break;
			}
		}
		System.out.print(sb);
	}
}