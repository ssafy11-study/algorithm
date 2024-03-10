import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] inputs;
    static List<int[]> result = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inputs = new int[N][];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            inputs[i] = new int[] { start, end };
        }

        Arrays.sort(inputs, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

        int startLimit = 0;
        for (int i = 0; i < N; i++) {
            int start = inputs[i][0];
            int end = inputs[i][1];

            if (startLimit <= start) {
                result.add(inputs[i]);
                startLimit = end;
            }
        }
        System.out.println(result.size());
    }
}