import java.io.*;
import java.util.*;


public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] cows = new int[N][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cows, Comparator.comparingInt(o1 -> o1[0]));
        int start = cows[0][0];
        int end = cows[0][1];
        int ans = 1;
        if(start > 1){
            System.out.println(-1);
            return ;
        }
        for(int[] cow : cows) {
            if(cow[0] <= start){
                if(end < cow[1]) end = cow[1];
            }
            else{
                start = end + 1;
                ans++;
                if(cow[0] <= start){
                    if(end < cow[1]) end = cow[1];
                }
                else break;
            }
            if(end >= M) break;
        }
        System.out.println(end < M ? -1 : ans);
    }
}
