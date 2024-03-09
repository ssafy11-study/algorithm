import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        // 수의 개수
        int N = Integer.parseInt(st.nextToken());
        // 합을 구해야하는 횟수 M
        int M = Integer.parseInt(st.nextToken());
        int[] array = new int[N + 1];
        st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());

        array[1] = start;

        for (int i = 2; i <= N; i++) {
            array[i] = start + Integer.parseInt(st.nextToken());
            start = array[i];
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int ss = Integer.parseInt(st.nextToken());
            int ee = Integer.parseInt(st.nextToken());
            sb.append(array[ee] - array[ss - 1]).append("\n");
        }
        System.out.println(sb);
    }
}