import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {	
		int set = 0;
		int value = 0;
		
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "add":
				value = Integer.parseInt(st.nextToken());
				set = set | 1 << value;
				break;
			case "remove":
				value = Integer.parseInt(st.nextToken());
				set = set & ~(1 << value);
				break;
			case "check":
				value = Integer.parseInt(st.nextToken());
				bw.write((set & 1 << value) != 0 ? "1" : "0");
				bw.newLine();
				break;
			case "toggle":
				value = Integer.parseInt(st.nextToken());
				set = set ^ 1 << value;
				break;
			case "all":
				set = 2_097_151;
				break;
			case "empty":
				set = 0;
				break;
			}
		}
		
		bw.flush();
		bw.close();
	}
}
