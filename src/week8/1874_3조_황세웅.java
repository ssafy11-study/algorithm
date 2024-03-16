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
	
	static int N, t;
	static boolean no;
	static Deque<Integer> stack = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		while (N-- > 0) {
			int n = Integer.parseInt(br.readLine());
			if (no) continue;
			while (n > t) {
				stack.push(++t);
				sb.append("+\n");
			}
			sb.append("-\n");
			if (stack.pop() != n) no = true;
		}
		System.out.print(no ? "NO" : sb);
	}
}