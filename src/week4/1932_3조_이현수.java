package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1932_3조_이현수 {
    static int[][] triangle;
    static int N;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        triangle = new int[N][];
        triangle[0] = new int[1];
        triangle[0][0] = Integer.parseInt(br.readLine());

        if(N > 1){
            st = new StringTokenizer(br.readLine());
            triangle[1] = new int[2];
            triangle[1][0] = triangle[0][0] + Integer.parseInt(st.nextToken());
            triangle[1][1] = triangle[0][0] + Integer.parseInt(st.nextToken());

            for(int i = 2; i < N; i++){
                triangle[i] = new int[i+1];
                st = new StringTokenizer(br.readLine());
                triangle[i][0] = Integer.parseInt(st.nextToken()) + triangle[i-1][0]; // 가장 왼쪽
                for(int j = 1; j <= i-1; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    triangle[i][j] = Math.max(triangle[i-1][j-1] + temp, triangle[i-1][j] + temp); // 중간
                }
                triangle[i][i] = Integer.parseInt(st.nextToken()) + triangle[i-1][i-1]; // 가장 오른쪽
            }
        }


        for(int i = 0; i < N; i++) answer = Math.max(answer, triangle[N-1][i]);
        System.out.print(answer);
    }
}
