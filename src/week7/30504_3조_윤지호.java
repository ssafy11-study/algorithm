import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] rent, money;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		rent = new int[N];
		money = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			rent[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}

		int[] org = rent.clone();
		Arrays.sort(rent);
		Arrays.sort(money);

		HashMap<Integer, Queue<Integer>> hashmap = new HashMap<>();

		// 갚을 수 있는지 검사
		for (int i = 0; i < N; i++) {
			if (rent[i] <= money[i]) {
				hashmap.putIfAbsent(rent[i], new ArrayDeque<>());
				hashmap.get(rent[i]).offer(money[i]);
			} else {
				System.out.println(-1);
				return;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(hashmap.get(org[i]).poll()).append(" ");
		}
		System.out.println(sb);
	}
}