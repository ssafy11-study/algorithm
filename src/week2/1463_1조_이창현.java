import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	//이창현
	static int N, result;
	static int[] dp = new int[1000001];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp[2] = 1;
		dp[3] = 1;
		for (int i = 4; i < dp.length; i++) {
			if(i%6==0) {
				int a = dp[i/3]+1;
				int b = dp[i/2]+1;
				dp[i] = Math.min(a, b);
			} else if(i%3==0){
				dp[i] = (dp[i/3]) < (dp[i-1]) ? dp[i/3]+1 : dp[i-1] +1;
			} else if(i%2==0){
				dp[i] = (dp[i/2]) < (dp[i-1]) ? dp[i/2]+1 : dp[i-1] +1;
			} else {
				dp[i] = dp[i-1] + 1;
			}
		}
		
		System.out.println(dp[N]);
	}
}
