import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] accu; // 현재 index 까지 누적된 합을 저장.
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		accu = new int[N + 1]; // 0 dummy
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			accu[i] = accu[i - 1] + Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			sb.append(accu[to] - accu[from - 1]).append("\n");
		}
		System.out.println(sb);
	}
}