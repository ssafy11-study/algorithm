package SSAFY.study.week7.t1865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 987_654_321;
    static int T, N, M, W, eLen;
    static Edge[] edges;
    static int[] dist;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            edges = new Edge[M*2+W];
            dist = new int[N + 1];
            for (int i = 0; i <= N; i++) {
                dist[i] = INF;
            }
            eLen = 0;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                edges[eLen++] = new Edge(u, v, w);
                edges[eLen++] = new Edge(v, u, w);
            }
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                edges[eLen++] = new Edge(u, v, -1 * w);
            }
            dist[1] = 0;
            boolean cycle = false;
            for (int i = 1; i <= N; i++) {
                for (int j = 0; j < eLen; j++) {
                    Edge e = edges[j];
                    if (dist[e.u] + e.w < dist[e.v]) {
                        if (i == N) {
                            cycle = true;
                            break;
                        }
                        dist[e.v] = dist[e.u] + e.w;
                    }
                }
                if(cycle) break;
            }
            if (cycle) sb.append("YES");
            else sb.append("NO");
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static class Edge {
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}

