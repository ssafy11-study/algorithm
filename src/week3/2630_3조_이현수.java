package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2630_3조_이현수 {
    static int[][] paper;
    static int whiteAnswer = 0;
    static int blueAnswer = 0;

    static void recur(int x1, int y1, int x2, int y2){
        int checkInt = (x2 - x1) * (y2 - y1);
        int cnt = 0;

        // cnt가 -1 * checkInt 면 하얀색, checkInt 면 파란색
        for(int i = x1; i < x2; i++){
            for(int j = y1; j < y2; j++){
                if(paper[i][j] == 1) cnt++;
                else cnt--;
            }
        }
        if(cnt < 0 && cnt == checkInt * -1) whiteAnswer++;
        else if(cnt > 0 && cnt == checkInt) blueAnswer++;

        else{
            // 1사분면
            recur(x1,y1, (x1+x2) / 2, (y1+y2) / 2);
            // 2사분면
            recur(x1, (y1+y2) / 2, (x1+x2) / 2, y2);
            // 3사분면
            recur((x1+x2) / 2, y1, x2, (y1+y2) / 2);
            // 4사분면
            recur((x1+x2) / 2, (y1+y2) / 2, x2, y2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0,0, N, N);

        System.out.println(whiteAnswer);
        System.out.print(blueAnswer);
    }

}
