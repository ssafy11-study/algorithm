package SSAFY.study.week5.t1697;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
/*
    baekjoon 1697 숨바꼭질
    수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
    수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
    순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
    수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

    풀이 -> BFS
    Idea 떠올리는 것이 어렵네...
 */
public class Main {
    static int N, M;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        Deque<int[]> queue = new ArrayDeque<>();
        visited = new boolean[1000000];
        queue.add(new int[]{M, 0});
        visited[M] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cVal = cur[0];
            int cCnt = cur[1];
            if (cVal == N) {
                System.out.println(cCnt);
                break;
            }
            if (cVal - 1 >= 0 && !visited[cVal - 1]) {
                visited[cVal-1] = true;
                queue.add(new int[]{cVal - 1, cCnt + 1});
            }
            if (!visited[cVal + 1]) {
                visited[cVal+1] = true;
                queue.add(new int[]{cVal + 1, cCnt + 1});
            }
            if (cVal % 2 == 0 && !visited[cVal / 2]) {
                visited[cVal/2] = true;
                queue.add(new int[]{cVal / 2, cCnt + 1});
            }

        }

    }
}
