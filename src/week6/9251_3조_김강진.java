import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    //LCS ( Longest Common Subsequence) - 최장 공통 부분 문자열.
    // 연속적이지 않아도 됨, DP 이용하여 해결
    // 점화식
    //  dp[0][0] = 0; ==> 초기화, 겹치는 문자가 없음
    //  if (a_i == b_j) dp[i][j] = dp[i-1][j-1] + 1;    ==> 겹치는 문자일 경우 이전 값 +1
    //  if (a_i != b_j) dp[i][j] = max(dp[i-1][j], dp[i][j-1]); ==> 겹치지 않는경우 <최장> 공통부분 문자열 이기때문에, 둘중 큰값
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        int[][] dp = new int[str1.length+1][str2.length+1]; // dp 배열 생성
        dp[0][0] = 0;

        for (int i =1;i<=str1.length;i++){
            for (int j=1;j<=str2.length;j++){
                if (str1[i-1] == str2[j-1]) dp[i][j] = dp[i-1][j-1]+1;
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[str1.length][str2.length]);
    }
}
