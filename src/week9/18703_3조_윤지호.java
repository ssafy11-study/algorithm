import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int T, N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());

			HashMap<String, Integer> set = new HashMap<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				int id = Integer.parseInt(st.nextToken());

				if (set.containsKey(name)) {
					int n = set.get(name);
					if (id < n) {
						set.put(name, id);
					}
				} else {
					set.put(name, id);
				}
			}
			List<Integer> result = new ArrayList(set.values());
			result.sort((o1, o2) -> o1 - o2);
			for(int n : result) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}