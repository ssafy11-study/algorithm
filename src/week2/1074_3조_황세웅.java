import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static int n, r, c, ans, cnt;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		move(pow(n), 0, 0);
		System.out.println(ans);
	}

	static void move(int n, int row, int column) {
		if (n == 2) {
			for (int i = row; i < row + 2; i++) {
				for (int j = column; j < column + 2; j++) {
					if (r == i && j == c) {
						ans = cnt;
					}
					cnt++;
				}
			}
			return;
		}
		
		int half = n / 2;
		if (r < row + half) {
			if (c < column + half) {
				move(half, row, column);
			} else {
				cnt += half * half;
				move(half, row, column + half);
			}
		} else {
			if (c < column + half) {
				cnt += half * half * 2;
				move(half, row + half, column);
			} else {
				cnt += half * half * 3;
				move(half, row + half, column + half);
			}
		}
		
	}

	static int pow(int e) {
		if (e == 1) {
			return 2;
		}
		int powed = pow(e / 2);
		if (e % 2 == 0) {
			return powed * powed;
		}
		return 2 * powed * powed;
	}

}
