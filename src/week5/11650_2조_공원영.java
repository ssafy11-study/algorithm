package SSAFY.study.week5.t11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static PriorityQueue<Point> pq;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>((o1, o2) -> {
            int x1 = o1.x;
            int x2 = o2.x;
            if(x1 != x2) return x1 - x2;
            return o1.y - o2.y;
        });
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.    parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.add(new Point(x, y));
        }
        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            sb.append(cur.x).append(' ').append(cur.y).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
