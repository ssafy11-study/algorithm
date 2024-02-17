package submit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S9095 {
    static final int N = 10; // 범위: 양수이며 10보다 작거나 같음
    static int[] arr = new int[N+1];

    // 0: 1, 1: 1, 2: 2, 3: 4 4: 7 누적합
    static void solution(){
        for(int i = 2; i <= N; i++){
            for(int j = 1; j <= 3; j++){
                if(i-j > -1) arr[i] += arr[i-j];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        arr[0] = 1;
        arr[1] = 1;

        solution();

        for(int t = 0; t < T; t++){
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n]).append("\n");
        }
        System.out.println(sb);

    }
}

