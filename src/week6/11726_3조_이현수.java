import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class _11726_3조_이현수 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];

        System.out.println(topDown(n));
    }

    static int topDown(int n){
        if(n == 1) return 1;
        else if(n == 2) return 2;
        if(dp[n] != 0) return dp[n];

        return dp[n] = (topDown(n-2) + topDown(n-1)) % 10007;
    }
}
