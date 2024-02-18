import java.io.*;
import java.util.*;
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] dp = new int[N + 1][N + 1];
        dp[1][1] = Integer.parseInt(br.readLine());
        int n;
        for(int i = 2; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < i + 1; j++){
                n = Integer.parseInt(st.nextToken());
                if(dp[i - 1][j] > dp[i - 1][j - 1]) dp[i][j] = n + dp[i - 1][j];
                else dp[i][j] = n + dp[i - 1][j - 1];
            }
        }
        int answer = 0;
        for(int num : dp[N]){
            if(num > answer) answer = num;
        }
        System.out.println(answer);
    }
}
