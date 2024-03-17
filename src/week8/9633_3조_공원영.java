package SSAFY.study.week8.t9633;


import java.util.Scanner;
/*
    baekjoon 9663 n-queen

 */
public class Main {
    static int N, answer;
    static int[] map; // index => row, value => col
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        N = sc.nextInt();
        map = new int[N + 1];
        answer = 0;
        backtracking(1);
        System.out.println(answer);
        sc.close();
    }

    static void backtracking(int cnt) {
        if (cnt == N + 1) {
            answer++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            map[cnt] = i; // cnt행 i번째 열에 퀸을 둔다. 동일 행에 두 개의 퀸이 존재하지 않는다.
            if (check(cnt)) { // 둘 수 있는지 체크
                backtracking(cnt + 1); // 진행.
            }
        }
    }

    static boolean check(int r) {
        for (int i = r - 1; i > 0; i--) { // 이미 놓은 퀸들에 상태를 보고 둘 수 있는지 판단해야 한다.
            // 1. r행과 i행에 둔 퀸이 같은 열에 있거나, 2. 두 퀸 사이의 행거리와 열거리과 같다면...r행에 퀸을 둘 수 없다.
            // 1. 같은 열의 두 개의 퀸이 존재할 수 없다. 2. 두 개의 퀸이 대각선으로 마주해선 안된다.
            if (map[r] == map[i] || r - i == Math.abs(map[r] - map[i])) {
                return false;
            }
        }
        return true;
    }
}
