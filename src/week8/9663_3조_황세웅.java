import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N, ans;
	static boolean[] col, lcross, rcross;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		col = new boolean[15];
		lcross = new boolean[30];
		rcross = new boolean[30];
		
		backtracking(0);
		System.out.println(ans);
	}
	
	static void backtracking(int r) {
		if (r == N) {
			ans++;
			return;
		}
		for (int c = 0; c < N; c++) {
			if (col[c] || lcross[r - c + 15] || rcross[r + c]) continue;
			col[c] = true; lcross[r - c + 15] = true; rcross[r + c] = true;
			backtracking(r + 1);
			col[c] = false; lcross[r - c + 15] = false; rcross[r + c] = false;
		}
	}
}