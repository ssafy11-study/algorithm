import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());

		Pos[] seq = new Pos[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			seq[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Pos p = seq[0];
		double acc = 0;
		for (int i = 1; i < n - 1; i++) {
			Pos v1 = p.to(seq[i]);
			Pos v2 = seq[i].to(seq[i + 1]);
			acc += product(v1, v2);
		}
		System.out.printf("%.1f", Math.abs(acc) / 2.0);
	}

	static long product(Pos v1, Pos v2) {
		return v1.x * v2.y - v1.y * v2.x;
	}

	static class Pos {
		long x;
		long y;

		Pos(long x, long y) {
			this.x = x;
			this.y = y;
		}

		Pos to(Pos o) {
			return new Pos(o.x - this.x, o.y - this.y);
		}
	}
}
