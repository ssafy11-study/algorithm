import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[] seq;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		seq = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] ans = {0, 0};
		int min = Integer.MAX_VALUE;
		int l = 0;
		int r = N - 1;
		
		while (l < r) {
			int s = seq[l] + seq[r];
			if (Math.abs(s) < min) {
				min = Math.abs(s);
				ans = new int[] {seq[l], seq[r]};
			}
			if (s < 0) l++;
			else r--;
		}
		
		System.out.println(ans[0] + " " + ans[1]);
	}
}