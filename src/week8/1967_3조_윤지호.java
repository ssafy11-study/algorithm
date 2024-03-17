import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static List<List<int[]>> map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			map.add(new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			map.get(from).add(new int[] { to, w });
			map.get(to).add(new int[] { from, w });
		}

		// 1차 탐색
		visit = new boolean[n + 1];
		visit[1] = true;
		maxSum = Integer.MIN_VALUE;
		dfs(1, 0);

		// 2차 탐색
		visit = new boolean[n + 1];
		visit[nextStartIdx] = true;
		maxSum = Integer.MIN_VALUE;
		dfs(nextStartIdx, 0);

		System.out.println(maxSum);
	}

	static int maxSum, nextStartIdx;
	static boolean[] visit;

	static void dfs(int idx, int sum) {
		maxSum = Math.max(sum, maxSum);
		if (maxSum == sum) {
			nextStartIdx = idx;
		}

		for (int[] temp : map.get(idx)) {
			int to = temp[0];
			int w = temp[1];
			if (w != 0 && !visit[to]) {
				visit[to] = true;
				dfs(to, sum + w);
			}
		}
	}
}