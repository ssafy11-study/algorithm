package SSAFY.study.week5.t1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
    백준 1005 ACN Craft

    위상정렬 문제
    문제 해결
    간선을 끊어내는 순서 -> 건설 시간이 빠른 기준(누적 시간을 의미한다)
    u1(u1을 건설하는데까지 걸린 누적 시간 100s) u2(u2를 건설하는데까지 걸린 누적 시간.10s)
    u1 -> v, u2 -> v가 있을 때 u1 -> v 간선을 먼저 제거한다.
 */
public class Main {
    static int N, M, W;
    static List<Integer>[] list;
    static int[] weights;
    static int[] in;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            list = new List[N + 1];
            weights = new int[N + 1];
            in =new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
                weights[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                list[u].add(v);
                in[v]++;
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
                return o1[1] - o2[1];
            });
            for(int i=1; i<=N; i++) if(in[i]==0) pq.add(new int[]{i, weights[i]});
            W = Integer.parseInt(br.readLine());
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                if (cur[0] == W) {
                    sb.append(cur[1]).append('\n');
                    break;
                }
                for (int next : list[cur[0]]) {
                    if(in[next] == 0) continue;
                    in[next]--;
                    if (in[next] == 0) {
                        pq.add(new int[]{next, cur[1] + weights[next]}); // 누적 건설 시간을 계산
                    }
                }
            }
        }
        System.out.println(sb);
        br.close();
    }

}
