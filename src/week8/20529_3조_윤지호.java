import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T, N, result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			String[] input = new String[N];
			for (int i = 0; i < N; i++) {
				input[i] = st.nextToken();
			}

			if (N >= 33) {
				System.out.println(0);
				continue;
			}

			result = Integer.MAX_VALUE;
			for (int i = 0; i < N - 2; i++) {
				for (int j = i + 1; j < N - 1; j++) {
					for (int k = j + 1; k < N; k++) {
						if (result == 0) {
							break;
						}
						int temp = 0;
						for (int c = 0; c < 4; c++) {
							temp += input[i].charAt(c) != input[j].charAt(c) ? 1 : 0;
							temp += input[j].charAt(c) != input[k].charAt(c) ? 1 : 0;
							temp += input[i].charAt(c) != input[k].charAt(c) ? 1 : 0;
						}
						result = Math.min(result, temp);
					}
				}
			}
			System.out.println(result);
		}
	}
}