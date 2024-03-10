package SSAFY.study.week7.t30504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, cnt;
    static PriorityQueue<A> AA = new PriorityQueue<>((o1, o2) -> {
        A a1 = (A)o1;
        A a2 = (A)o2;
        return a1.v - a2.v;
    });
    static int[] answer;
    static PriorityQueue<Integer> B = new PriorityQueue<>(); // 자루 금액
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        answer = new int[N];
        cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(st.nextToken());
            AA.add(new A(v, i));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < N; i++) {
            A a = AA.poll();
            int b = B.poll();
            if(b >= a.v){
                answer[a.idx] = b;
                cnt++;
            }else break;
        }
        if(cnt != N) sb.append(-1);
        else for (int i = 0; i < N; i++) sb.append(answer[i]).append(" ");
        System.out.println(sb);
        br.close();
    }

    static class A {
        int v, idx;

        public A(int v, int idx) {
            this.v = v;
            this.idx = idx;
        }
    }
}
