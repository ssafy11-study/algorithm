import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Deque<String> deque = new ArrayDeque<>();

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();

			switch (cmd) {
			case "push":
				String value = st.nextToken();
				deque.addLast(value);
				break;
			case "pop":
				if (deque.isEmpty()) {
					bw.write("-1");
					bw.newLine();
					break;
				}
				bw.write(deque.pollFirst());
				bw.newLine();
				break;
			case "size":
				bw.write(Integer.toString(deque.size()));
				bw.newLine();
				break;
			case "empty":
				bw.write(deque.isEmpty() ? "1" : "0");
				bw.newLine();
				break;
			case "front":
				if (deque.isEmpty()) {
					bw.write("-1");
					bw.newLine();
					break;
				}
				bw.write(deque.peekFirst());
				bw.newLine();
				break;
			case "back":
				if (deque.isEmpty()) {
					bw.write("-1");
					bw.newLine();
					break;
				}
				bw.write(deque.peekLast());
				bw.newLine();
				break;
			}
		}
		bw.flush();
		bw.close();
	}
}