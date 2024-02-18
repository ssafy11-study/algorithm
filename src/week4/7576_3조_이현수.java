package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Tomato {
    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] box, distance;
    static int N, M;

    static Queue<Point> q = new LinkedList<>();

    static void BFS(){
        Point p;
        while(!q.isEmpty()){
            p = q.poll();
            for(int i = 0; i < dx.length; i++){
                int tempX = p.x + dx[i];
                int tempY = p.y + dy[i];

                if(tempX < N && tempX >= 0 && tempY < M && tempY >= 0 && box[tempX][tempY] == 0) { // 익은 토마토가 아닐 때
                    box[tempX][tempY] = 1;
                    q.offer(new Point(tempX, tempY));
                    distance[tempX][tempY] = distance[p.x][p.y] + 1;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean flag = true;
        int answer = Integer.MIN_VALUE;

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        distance = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1) q.add(new Point(i, j));
            }
        }

        BFS();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(box[i][j] == 0) {
                    flag = false;
                    break;
                }
                answer = Math.max(distance[i][j], answer);
            }
        }

        if(flag) System.out.print(answer);
        else System.out.print(-1);
    }
}
