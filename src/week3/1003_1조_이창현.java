import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	// 이창현
	static int N, num;
	static int[][] dp;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dp = new int[41][2];

		dp[0][0] = 1;  
		dp[0][1] = 0;  
		dp[1][0] = 0;  
		dp[1][1] = 1;  
		
		for (int j = 2; j < 41; j++) {
			dp[j][0] = dp[j-1][0] + dp[j-2][0];
			dp[j][1] = dp[j-1][1] + dp[j-2][1];
		}
		
		for (int i = 0; i < N; i++) {
			
			num = Integer.parseInt(br.readLine());
			
			sb.append(dp[num][0]).append(" ").append(dp[num][1]).append("\n");
		}
		System.out.println(sb);
	}
	
}
