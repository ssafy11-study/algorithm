import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N, M, ans;
	static int[] back = new int[6];
	static boolean[] broken = new boolean[10];

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		if (M > 0) st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			broken[Integer.parseInt(st.nextToken())] = true;
		}
		
		ans = Math.abs(N - 100);
		for (int i = 1; i <= 6; i++) {
			backtracking(0, i);			
		}
		System.out.println(ans);
	}
	
	static void backtracking(int cnt, int max) {
		if (cnt == max) {
			int n = 0;
			for (int i = 0; i < max; i++) {
				n *= 10;
				n += back[i];
			}
			ans = Math.min(ans, Math.abs(N - n) + max);
			return;
		}
		for (int i = 0; i < 10; i++) {
			if (broken[i]) continue;
			back[cnt] = i;
			backtracking(cnt + 1, max);
		}
	}
}
