import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static boolean[] prime = new boolean[1001];
	
	static {
		for (int i = 2; i < 1001; i++) {
			for (int j = i * 2; j < 1001; j += i) {
				prime[j] = true;
			}
		}
		prime[1] = true;
	}

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (!prime[Integer.parseInt(st.nextToken())]) cnt++;
		}
		System.out.println(cnt);
	}
}