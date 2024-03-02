import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
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
		Arrays.sort(seq);
		
		int acc = 0;
		int prev = 0;
		for (int i = 0; i < N; i++) {
			prev += seq[i];
			acc += prev;
		}
		System.out.println(acc);
	}
}