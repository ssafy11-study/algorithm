import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] houses,dp;
    static StringTokenizer st;
    // 집은 이웃한 두 집과 색이 달라야한다.
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        houses = new int[N][3];
        dp = new int[N][3];


        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                houses[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0] = houses[0];
        for(int i=1;i<N;i++){
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Math.min(dp[i-1][(j+1)%3],dp[i-1][(j+2)%3]) + houses[i][j];
            }
        }
        System.out.println(Arrays.stream(dp[N-1]).min().getAsInt());
    }
}
