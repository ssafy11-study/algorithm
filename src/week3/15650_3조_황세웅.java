import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static Stack<String> stack = new Stack<>();
	static int n, m;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		backtracking(1);
		bw.flush();
		bw.close();
	}
	
	static void backtracking(int start) throws IOException {
		if (stack.size() == m) {
			bw.write(String.join(" ", stack));
			bw.newLine();
			return;
		}
		for (int i = start; i <= n; i++) {
			stack.push(String.valueOf(i));
			backtracking(i + 1);
			stack.pop();
		}
	}
}
