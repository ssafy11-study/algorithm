package SSAFY.study.week8.t9328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;
/*
    baekjoon 9328 열쇠
    삼차원 방문처리는 키의 수가 크기 때문에 불가능...다른 방법 필요
    만약 특정 문에 대한 키를 가지지 못한 상태에서 문에 도착 시 상태 저장이 필요
 */
public class Main {
    static int T, R, C, answer, key;
    static int[][] map;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static boolean[][][] visited;
    static String s;
    static Deque<int[]> queue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
