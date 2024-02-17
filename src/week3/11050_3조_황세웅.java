import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static int n, k;

	static List<Long> factorial = new ArrayList<>();
	static {
		factorial.add(1L);
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		System.out.println(binomial(n, k));
	}

	static long binomial(int n, int r) {
		if (r == 0 || n == r) {
			return 1;
		}
		if (r > n || n < 0 || r < 0) {
			return 0;
		}
		return getFact(n) / (getFact(r) * getFact(n - r));
	}

	static long getFact(int n) {
		while (n >= factorial.size()) {
			factorial.add(factorial.get(factorial.size() - 1) * factorial.size());
		}
		return factorial.get(n);
	}
}