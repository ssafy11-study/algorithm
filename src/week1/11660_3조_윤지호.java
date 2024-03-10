import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] accu; // 현재 index 까지 누적된 합을 저장.
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		accu = new int[N + 1][N + 1]; // 0 dummy
		for (int i = 1; i <= N; i++) { // 행 (아래)
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) { // 열 (옆)
				accu[i][j] = accu[i - 1][j] + accu[i][j - 1] - accu[i - 1][j - 1] + Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			sb.append(accu[x2][y2] - accu[x1-1][y2] - accu[x2][y1-1] + accu[x1-1][y1-1]).append("\n");
		}
		System.out.println(sb);
	}
}