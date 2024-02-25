import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, arr[], ans;
    static List<Integer> [] dp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new List[N];
        ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0;i<N;i++){
            dp[i] = new ArrayList<>();
            dp[i].add(arr[i]);
        }

        for (int i=0;i<N;i++){
            for (int j=0;j<i;j++){
                if (arr[i] <= arr[j]){
                    continue;
                }

                if (dp[j].size() +1 > dp[i].size()){
                    dp[i] = new ArrayList<>(dp[j]);
                    dp[i].add(arr[i]);
                }
            }
        }

        for(int i=0;i<N;i++){
//            System.out.println(dp[i]);
            ans = Math.max(ans, dp[i].size());
        }

        System.out.println(ans);
    }
}