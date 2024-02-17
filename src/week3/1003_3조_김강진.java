import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[][] dp = new int[41][2];
	static int T,num;
	
	static int last=0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		last = 2;
		
		for (int t=0;t<T;t++) {
			num = Integer.parseInt(br.readLine());
			while (last <= num) {
				if (num < 2) break;
				dp[last][0] = dp[last-1][0] + dp[last-2][0];
				dp[last][1] = dp[last-1][1] + dp[last-2][1];
				last++;
			}
			
			sb.append(dp[num][0]).append(" ").append(dp[num][1]).append("\n");
			
		}
		
		System.out.println(sb);
	}
	
}
