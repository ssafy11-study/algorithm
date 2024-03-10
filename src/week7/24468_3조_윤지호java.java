import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int L, N, T, result;
	static int[] dx = { -1, 1 }; // 좌 우
	static List<List<Integer>> map = new ArrayList<>(); // 맵에 같은 좌표의 구슬

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= L; i++) {
			map.add(new ArrayList<>());
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().toCharArray()[0];
			map.get(x).add(c == 'R' ? 1 : -1);
		}

		int time = 0;
		while (time <= T) {
			// 가장자리 충돌 확인 0, N
			for (int i = 0; i < map.get(0).size(); i++) {
				map.get(0).set(i, 1);
			}
			for (int i = 0; i < map.get(L).size(); i++) {
				map.get(L).set(i, -1);
			}

			// 내부 충돌 확인
			for (int i = 1; i < L; i++) {
				List<Integer> cur = map.get(i);
				// 충돌
				if (cur.size() >= 2) {
					for (int j = 0; j < cur.size(); j++) {
						int dir = map.get(i).get(j);
						map.get(i).set(j, dir * -1);
					}
					result++;
				}
			}

			// 이동 기록
			List<List<Integer>> temp = new ArrayList<>();
			for (int i = 0; i <= L; i++) {
				temp.add(new ArrayList<>());
			}

			// 이동
			for (int i = 0; i <= L; i++) {
				List<Integer> cur = map.get(i); // 현재 보고 있는 위치

				for (int j = cur.size() - 1; j >= 0; j--) {
					if (cur.get(j) == -1) {
						temp.get(i - 1).add(-1);
						map.get(i).remove(j);
					} else if (cur.get(j) == 1) {
						temp.get(i + 1).add(1);
						map.get(i).remove(j);
					}
				}
			}
			map = temp;
			time++;
		}
		System.out.println(result);
	}
}