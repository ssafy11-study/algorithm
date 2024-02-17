import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder[] ages = new StringBuilder[200];

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			
			if (ages[age - 1] == null) {
				ages[age - 1] = new StringBuilder();
			}
			ages[age - 1].append(age).append(" ").append(st.nextToken()).append("\n");
		}
		
		for (StringBuilder sb : ages) {
			if (sb == null) {
				continue;
			}
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}
}