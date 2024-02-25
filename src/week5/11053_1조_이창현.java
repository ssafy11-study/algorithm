import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 이창현
	static int N, max;
	static int[] dp, arr;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N =Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = 1;
		max = 1;
        
		for (int i = 1; i < N; i++) {
			dp[i] = 1;
			
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}

}