package dd;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_1259 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			boolean ans = true;
			String input = br.readLine();
			if (input.equals("0"))
				return;
			int strLen = input.length();
			int middle = strLen / 2;
			for (int i = 0; i < middle; i++) {
				if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
					ans = false;
					break;
				}
			}
			if (ans) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}

	}

}