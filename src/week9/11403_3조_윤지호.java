import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, start;
	static int[][] adjMatrix;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		adjMatrix = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num != 0) {
					adjMatrix[i][j] = num;
				} else {
					adjMatrix[i][j] = 101;
				}
			}
		}
		
		visit = new boolean[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (adjMatrix[j][k] > adjMatrix[j][i] + adjMatrix[i][k]) {
						adjMatrix[j][k] = adjMatrix[j][i] + adjMatrix[i][k];
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (adjMatrix[i][j] == 101) {
					sb.append(0);
				} else {
					sb.append(1);
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}