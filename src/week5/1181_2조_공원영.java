package SSAFY.study.week5.t1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.PriorityQueue;

// baekjoon 1181 단어 정렬
// 우선순위 큐
// 1. 길이가 짧은 순
// 2. 길이가 같다면 사전 순
// 단, 중복된 단어는 하나만 남기고 제거해야 한다.
// 사용할 자료구조
// Set -> 중복 제거
// PriorityQueue -> 정렬
public class Main {
    static int N;
    static PriorityQueue<String> pq;
    static HashSet<String> set;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        pq = new PriorityQueue<>((o1, o2) ->{
            int l1 = o1.length();
            int l2 = o2.length();
            if(l1 != l2) return l1-l2;
            return o1.compareTo(o2);
        });
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            pq.add(it.next());
        }
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}
