import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N][2];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1]:o1[0]-o2[0]);

        for(int[] a : list) {
            sb.append(a[0]).append(" ").append(a[1]).append("\n");
        }
        System.out.println(sb);
    }
}