// ref: https://www.acmicpc.net/source/67731562

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[] seq;
	static int[] res;
	static boolean[] visited;
	static int n, m;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		seq = new int[n];
		res = new int[m];
		visited = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(seq);
		
		backtracking(0);
		System.out.println(sb);
	}
	
	static void backtracking(int resIdx) {
		if (resIdx == m) {
			for (int i : res) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		int prev = -1;
		for (int i = 0; i < n; i++) {
			if (visited[i]) continue;
			if (seq[i] == prev) continue;
			prev = seq[i];
			res[resIdx] = seq[i];
			visited[i] = true;
			backtracking(resIdx + 1);
			visited[i] = false;
		}
	}
}
