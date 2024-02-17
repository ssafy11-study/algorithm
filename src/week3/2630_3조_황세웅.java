import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[][] direction = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
	static int[][] board;
	static int[][] acc;
	static int w, b;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());

		board = new int[n][n];
		acc = new int[n + 1][n + 1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = st.nextToken().charAt(0) - 48;
				acc[i + 1][j + 1] = acc[i][j + 1] + acc[i + 1][j] - acc[i][j] + board[i][j];
			}
		}
		
		for (int ans : split(n, 0, 0)) {
			System.out.println(ans);
		}
	}

	static int[] split(int n, int row, int column) {
		int[] ans = {0, 0};
		
		int checked = check(n, row, column);
		if (checked == 0 || checked == 1) {
			ans[checked] += 1;
			return ans;
		}
		
		for (int[] d: direction) {
			int nextRow = row + n / 2 * d[0];
			int nextColumn = column + n / 2 * d[1];
			int[] res = split(n / 2, nextRow, nextColumn);
			ans[0] += res[0];
			ans[1] += res[1];
		}
		
		return ans;
	}

	static int check(int n, int row, int column) {	
		int res = acc[row + n][column + n] - acc[row][column + n] - acc[row + n][column] + acc[row][column];
		if (res == 0) {
			return 0;
		}
		if (res == n * n) {
			return 1;
		}
		return -1;
	}
}
