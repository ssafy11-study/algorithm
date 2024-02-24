import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] seq, res;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N];
		seq = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(seq);
		
		res = new int[M];
		backtracking(0);
		System.out.println(sb);
	}
	
	static void backtracking(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(res[i]).append(" ");
			}
			sb.setCharAt(sb.length() - 1, '\n');
			return;
		}
		int prev = -1;
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			if (prev == seq[i]) continue;
			prev = seq[i];
			visited[i] = true;
			res[cnt] = seq[i];
			backtracking(cnt + 1);
			visited[i] = false;
		}
	}
}