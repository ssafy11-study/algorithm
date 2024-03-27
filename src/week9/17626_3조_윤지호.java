import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] pow = new int[225];
		for (int i = 1; i < pow.length; i++) {
			pow[i] = (int) Math.pow(i, 2);
		}

		int[] dp = new int[50001];
		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		System.out.println(dp[n]);
	}
}