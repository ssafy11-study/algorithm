import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			boolean ans = check(br.readLine().toCharArray());
			sb.append(ans ? "YES" : "NO").append("\n");
		}
		System.out.print(sb);
	}
	
	static boolean check(char[] seq) {
		int cnt = 0;
		for (char c : seq) {
			if (c == '(') cnt++;
			else if (--cnt < 0) return false;
		}
		if (cnt > 0) return false;
		return true;
	}
}