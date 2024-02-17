package 알고리즘_스터디._2주차.class2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _2164 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        Deque<Integer> queue = new ArrayDeque<Integer>();
        for(int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        for(int i = 0; i < N - 1; i++) {
            queue.poll();
            queue.add(queue.poll());

        }
        System.out.println(queue.poll());
    }
}