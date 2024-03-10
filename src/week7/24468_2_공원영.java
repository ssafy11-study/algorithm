package SSAFY.study.week7.t24468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    backjoon 24468
    8 2 5
    1 R
    5 L
 */
public class Main {
    static int L, N, T, cnt;
    static int[] loc;
    static Ball[] balls;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        loc = new int[L + 1];
        balls = new Ball[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);
            balls[i] = new Ball(x, d);
            loc[x] = 1;
        }
//        for (int i = 0; i < N; i++) {
//            System.out.println(balls[i].x + " " + balls[i].dir);
//        }
        cnt = 0;
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++) {
                // 공 이동
                Ball ball = balls[j];
                loc[ball.x]--;
                ball.x += ball.dir;
                loc[ball.x]++;
                if(ball.x == 0 || ball.x == L) ball.dir *= -1;
            }
            // 충돌 검사
            for (int j = 1; j < L; j++) {
                if (loc[j] > 1) {
                    cnt++;
                    for (int k = 0; k < N; k++) {
                        if(balls[k].x == j) balls[k].dir *= -1;
                    }
                }
            }
//            System.out.println(Arrays.toString(loc));
        }
        System.out.println(cnt);

        br.close();
    }

    static class Ball {
        int x, dir;

        public Ball(int x, char dir) {
            this.x = x;
            if(dir == 'L')  this.dir = -1;
            else this.dir = 1;
        }
    }
}
