import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T,n,ans;
	static int[][] arr,dp;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			n = Integer.parseInt(br.readLine());
			
			arr = new int[2][n+1];
			dp = new int[2][n+1];
			
			for(int i=0;i<2;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=1;j<=n;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][0] = dp[1][0] = 0;
			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];
			
			for(int i=2;i<=n;i++) {
				dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + arr[0][i];
				dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + arr[1][i];
			}
			
			sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
		}
		System.out.println(sb);
	}
}
