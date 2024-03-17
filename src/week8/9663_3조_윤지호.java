import java.util.Scanner;

public class Main {

	static int N, count;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		map = new int[N];
		dfs(0);
		System.out.println(count);
	}

	static int[] map;

	static void dfs(int row) {
		if (row == N) {
			count++;
			return;
		}

		// idx 번째 줄, x 위치 i
		for (int i = 0; i < N; i++) {
			map[row] = i;
			if (valid(row)) {
				dfs(row + 1);
			}
		}
	}

	// y 줄에 x가 와도 되는지
	static boolean valid(int r) {
		for (int i = 0; i < r; i++) {
			int curx = map[i];
			if (curx == map[r]) {
				return false;
			}
			if (Math.abs(r - i) == Math.abs(map[r] - curx)) {
				return false;
			}
		}
		return true;
	}
}