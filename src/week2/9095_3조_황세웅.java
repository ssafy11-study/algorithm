import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	
	static int[] dp = new int[11];

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			bw.write(Integer.toString(getDP(n)));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	static int getDP(int n) {
		if (dp[n] == 0) {
			dp[n] = getDP(n - 1) + getDP(n - 2) + getDP(n - 3);
		}
		return dp[n];
	}
}