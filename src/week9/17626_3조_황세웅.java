import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
    	N = Integer.parseInt(br.readLine());
    	
    	dp = new int[N + 1];
    	dp[1] = 1;
    	
    	for (int i = 2; i < N + 1; i++) {
    		dp[i] = 4;
    		int sqrt = (int)Math.sqrt(i);
    		if (i == sqrt * sqrt) {
    			dp[i] = 1;
    			continue;
    		}
    		for (int d = sqrt; d > 0; d--) {
    			dp[i] = Math.min(dp[i], dp[i - d * d] + 1);
    		}
    	}
    	System.out.println(dp[N]);
    }
};