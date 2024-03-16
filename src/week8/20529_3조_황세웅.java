import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T, N, ans;
	static String[] seq;

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			seq = new String[N];
			
			st = new StringTokenizer(br.readLine());
			
			if (N > 32) {
				sb.append(0).append("\n");
				continue;
			}
			
			for (int i = 0; i < N; i++) {
				seq[i] = st.nextToken();
			}
			
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < N - 2; i++) {
				for (int j = i + 1; j < N - 1; j++) {
					for (int k = j + 1; k < N; k++) {
						int d = diff(seq[i], seq[j]) + diff(seq[j], seq[k]) + diff(seq[i], seq[k]);
						ans = Math.min(ans, d);
					}
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
	}
	
	static int diff(String s1, String s2) {
		int res = 0;
		for (int i = 0; i < 4; i++) {
			if (s1.charAt(i) != s2.charAt(i)) res++;
		}
		return res;
	}
}