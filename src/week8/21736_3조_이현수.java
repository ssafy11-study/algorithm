import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static char[][] map;
    static Point I;
    static int N, M;
    static boolean[][] vtd;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        vtd = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) if(map[i][j] == 'I') I = new Point(i, j);
        }
        BFS();
        if(answer == 0) System.out.print("TT");
        else System.out.print(answer);
    }

    static void BFS(){
        Queue<Point> q = new LinkedList<>();
        q.add(I);
        while(!q.isEmpty()){
            Point p = q.poll();
            if(vtd[p.y][p.x]) continue;
            vtd[p.y][p.x] = true;

            for(int i = 0; i < 4; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if(0 > ny || ny >= N || 0 > nx || nx >= M || map[ny][nx] == 'X' || vtd[ny][nx] ) continue;

                if(map[ny][nx] == 'P') {
                    map[ny][nx] = 'O';
                    answer++;
                }
                q.add(new Point(ny, nx));
            }
        }
    }

    static class Point{
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
