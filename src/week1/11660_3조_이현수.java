package s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이현수
class Point{
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class FindSumOfIntervals {
    static StringBuilder sb = new StringBuilder();
    void solution(Point p1, Point p2){
        long sum = 0;
        for(int i = p1.x; i <= p2.x; i++){
            sum += matrix[i][p2.y] - matrix[i][p1.y-1]; // (2,2) (3,4)
            /**
             * dy = 2, 3
             * dx = 2, 3, 4
             *
             * */
        }
        sb.append(sum).append("\n");
    }
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        FindSumOfIntervals f = new FindSumOfIntervals();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 표의 크기
        int M = Integer.parseInt(st.nextToken()); // 연산 실행 횟수
        matrix = new int[N+1][N+1];

        int old, current;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            old = 0;
            for(int j = 1; j <= N; j++) {
                current = Integer.parseInt(st.nextToken());
                matrix[i][j] = old + current;
                old = matrix[i][j];
            }
        }

        Point p1, p2;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            p1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            p2 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            f.solution(p1, p2);
        }
        System.out.print(sb);
    }
}
