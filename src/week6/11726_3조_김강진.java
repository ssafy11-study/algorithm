
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, dp[];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[1001]; // 입력 범위 1~1000
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i =3;i<=N;i++){
            dp[i] = (dp[i-1]+dp[i-2])%10007;
        }

        System.out.println(dp[N]); // 출력
    }

}
