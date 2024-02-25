package 알고리즘_스터디._5주차.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15654 {
    static int[] array,output;
    static boolean[] visited;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new int[N];
        output = new int[M];
        visited = new boolean[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        recursion(0);
        System.out.println(sb);
    }

    public static void recursion(int depth) {

        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(output[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = array[i];
                recursion(depth + 1);
                visited[i] = false;
            }
        }
    }
}












