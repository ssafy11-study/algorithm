package SSAFY.study.week8.t20529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T, N, answer;
    static int[][] people;
    static int[] tgt = new int[3];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            answer = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            if (N < 48) {
                people = new int[N][4];
                for (int i = 0; i < N; i++) {
                    String m = st.nextToken();
                    for (int j = 0; j < 4; j++) {
                        char c = m.charAt(j);
                        switch (c) {
                            case 'E':
                            case 'S':
                            case 'T':
                            case 'J':
                                people[i][j] = 1;
                                break;
                        }
                    }
                }
                comb(0, 0);
                sb.append(answer);
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static void comb(int srcIdx, int tgtIdx) {
        if (tgtIdx == 3) {
            int sum = 0;
            for (int i = 0; i < 2; i++) {
                for (int j = i + 1; j < 3; j++) {
                    for (int k = 0; k < 4; k++) {
                        sum += Math.abs(people[tgt[i]][k] - people[tgt[j]][k]);
                    }
                }
            }
            answer = Math.min(answer, sum);
            return;
        }
        for (int i = srcIdx; i < N; i++) {
            tgt[tgtIdx] = i;
            comb(i + 1, tgtIdx + 1);
        }
    }
}
