import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N, M, ans;
	static boolean[] broken = new boolean[10];

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		if (M > 0) st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			broken[Integer.parseInt(st.nextToken())] = true;
		}
		
		ans = Math.abs(N - 100);
		/* 최적화 해봤지만, 큰 의미 없는듯
		if (M != 100) {
			for (int i = 0; i < Math.abs(N - 100) + N; i++) {
				if (!isBroken(i)) ans = Math.min(ans, Math.abs(N - i) + Integer.toString(i).length());
			}
		}
		*/
		for (int i = 0; i < 1_000_000; i++) {
			if (!isBroken(i)) ans = Math.min(ans, Math.abs(N - i) + Integer.toString(i).length());
		}
		System.out.println(ans);
	}
	
	static boolean isBroken(int n) {
		if (n == 0) return broken[0];
		while (n > 0) {
			if (broken[n % 10]) return true;
			n /= 10;
		}
		return false;
	}
}