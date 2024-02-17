import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int w, h;
	static int ax, ay, bx, by;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		ax = Integer.parseInt(st.nextToken());
		ay = Integer.parseInt(st.nextToken());
		bx = Integer.parseInt(st.nextToken());
		by = Integer.parseInt(st.nextToken());
		
		if (ax == bx) {
			System.out.printf("%d %d %d %d", 0, ay, w, by);
		} else {
			System.out.printf("%d %d %d %d", ax, 0, bx, h);
		}
	}
}
