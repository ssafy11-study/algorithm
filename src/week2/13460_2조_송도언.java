import java.io.*;
import java.util.*;

class Move{
    int rx, ry;
    int bx, by;
    int cnt;
    boolean redExit;
    boolean blueExit;

    public Move(int rx, int ry, int bx, int by, int cnt, boolean redExit,  boolean blueExit) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.cnt = cnt;
        this.redExit = redExit;
        this.blueExit = blueExit;
    }

    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Move)) return false;

        Move m = (Move) obj;
        return this.rx == m.rx && this.ry == m.ry &&
                this.bx == m.bx && this.by == m.by;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rx, ry, bx, by);
    }

    @Override
    public String toString() {
        return "Move [rx=" + rx + ", ry=" + ry + ", bx=" + bx + ", by=" + by + ", cnt=" + cnt + ", redExit=" + redExit
                + ", blueExit=" + blueExit + "]";
    }


}

public class Main {
    static int N,M;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] redStart;
    static int[] blueStart;
    static int[] hole;

    static boolean firstMoveCheck(Move move, int dir) {
        if(dir == 0) {
            if(move.rx >= move.bx) return true;
            else return false;
        }
        else if(dir == 1) {
            if(move.rx <= move.bx) return true;
            else return false;
        }
        else if(dir == 2) {
            if(move.ry >= move.by) return true;
            else return false;
        }
        if(move.ry <= move.by) return true;
        return false;
    }

    static Move moving(Move move, int dir) {
        int tempRX, tempRY, tempBX, tempBY;
        int rX = move.rx;
        int rY = move.ry;
        int bX = move.bx;
        int bY = move.by;
        boolean redM, blueM;
        if(firstMoveCheck(move, dir)) {
            while(true) {
                tempRX = rX + dx[dir];
                tempRY = rY + dy[dir];
                redM = movable(tempRX, tempRY);
                if(redM) {
                    rX = tempRX;
                    rY = tempRY;

                    if(exit(rX, rY)) {
                        rX = 0;
                        rY = 0;
                        move.redExit = true;
                    }
                }
                tempBX = bX + dx[dir];
                tempBY = bY + dy[dir];
                blueM = movable(tempBX, tempBY);
                if(tempBX == rX && tempBY == rY)break;
                if(blueM) {
                    bX = tempBX;
                    bY = tempBY;
                    if(exit(bX, bY)) {
                        move.blueExit = true;
                        break;
                    }
                }

                if(!redM && !blueM) break;
            }
        }
        else {
            while(true) {
                tempBX = bX + dx[dir];
                tempBY = bY + dy[dir];
                blueM = movable(tempBX, tempBY);
                if(blueM) {
                    bX = tempBX;
                    bY = tempBY;
                    if(exit(bX, bY)) {
                        move.blueExit = true;
                    }
                }

                tempRX = rX + dx[dir];
                tempRY = rY + dy[dir];
                redM = movable(tempRX, tempRY);
                if(tempRX == bX && tempRY == bY)break;
                if(redM) {
                    rX = tempRX;
                    rY = tempRY;

                    if(exit(rX, rY)) {
                        move.redExit = true;
                        break;
                    }


                }
                if(!redM && !blueM) break;
            }
        }
        return new Move(rX, rY, bX, bY, move.cnt + 1,move.redExit, move.blueExit);

    }
    static boolean exit(int x, int y) {
        return x == hole[0] && y == hole[1];
    }
    static boolean outOfMap(int x, int y) {
        return x > 0 && x < N && y > 0 && y <= M;
    }
    static boolean movable(int x, int y) {
        return x > 0 && x <= N && y > 0 && y <= M && map[x][y] != '#';
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Queue<Move> queue = new LinkedList<>();
        Set<Move> set = new HashSet<>();
        int redX, redY, blueX, blueY;
        map = new char[N + 1][M + 1];
        String row;
        for(int i = 1; i <= N; i++) {
            row = br.readLine();
            for(int j = 1; j <= M; j++) {
                map[i][j] = row.charAt(j - 1);
                if(map[i][j] == 'R') redStart = new int[] {i, j};
                if(map[i][j] == 'B') blueStart = new int[] {i, j};
                if(map[i][j] == 'O') hole = new int[] {i, j};
            }
        }
        int answer = -1;
        queue.add(new Move(redStart[0],redStart[1],
                blueStart[0], blueStart[1], 0, false, false));
//		int idx = 0;
        while(!queue.isEmpty()) {
            Move m = queue.poll();

            if(m.cnt > 10) break;
            if(m.redExit) {
                if(m.blueExit) continue;
                System.out.println(m.cnt);
                return ;
            }
            if(m.blueExit) continue;
            for(int i = 0; i < 4; i++) {
                Move next = moving(new Move(m.rx, m.ry, m.bx, m.by, m.cnt, m.redExit, m.blueExit), i);
                if(set.contains(next)) continue;
                queue.add(next);
                set.add(next);
            }

        }

        System.out.println(answer);

    }
}
