
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class _15663 {
    static int[] numbers;
    static int[] sequence;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        sequence = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        backtrack(0);
    }

    public static void backtrack(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(sequence[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }

        int lastUsed = -1;
        for (int i = 0; i < N; i++) {
            if (!visited[i] && (lastUsed != numbers[i])) {
                visited[i] = true;
                sequence[depth] = numbers[i];
                backtrack(depth + 1);
                visited[i] = false;
                lastUsed = numbers[i];
            }
        }
    }
}
