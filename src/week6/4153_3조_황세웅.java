import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[] seq = new int[3];

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(br.readLine());
			seq[0] = Integer.parseInt(st.nextToken());
			seq[1] = Integer.parseInt(st.nextToken());
			seq[2] = Integer.parseInt(st.nextToken());
			if (seq[0] == 0 && seq[1] == 0 && seq[2] == 0) break;
			Arrays.sort(seq);
			sb.append(seq[0] * seq[0] + seq[1] * seq[1] == seq[2] * seq[2] ? "right\n" : "wrong\n");
		}
		System.out.println(sb);
	}
}