import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static char[] str1;
	static char[] str2;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();

		map = new int[str1.length + 1][str2.length + 1];

		for (int i = 1; i < str1.length + 1; i++) {
			for (int j = 1; j < str2.length + 1; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					map[i][j] = map[i - 1][j - 1] + 1;
				} else {
					map[i][j] = Math.max(map[i][j - 1], map[i - 1][j]);
				}
			}
		}
		System.out.println(map[str1.length][str2.length]);
	}
}