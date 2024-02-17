package baekjoon.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution11660 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] accTable = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j < n + 1; j++) {
                accTable[i][j] += accTable[i - 1][j] + accTable[i][j - 1] - accTable[i - 1][j - 1] + line[j - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sub1 = accTable[x2][y1 - 1];
            int sub2 = accTable[x1 - 1][y2];
            int add = accTable[x1 - 1][y1 - 1];

            int acc = accTable[x2][y2];

            bw.write(String.valueOf(acc - sub1 - sub2 + add));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
