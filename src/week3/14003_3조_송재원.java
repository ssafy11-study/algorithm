import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        int[] coll = new int[N+1];
        int[] answer = new int[N+1];
        int[] trace = new int[N+1];

        StringTokenizer st = new StringTokenizer(reader.readLine());

        coll[0] = Integer.parseInt(st.nextToken());
        answer[0] = coll[0];
        trace[0] = 0;

        int ai = 0;
        for (int i = 1; i < N; ++i) {
            coll[i] = Integer.parseInt(st.nextToken());

            if (answer[0] > coll[i]) {
                answer[0] = coll[i];
                trace[i] = 0;
            } else if (answer[ai] < coll[i]) {
                ai++;
                answer[ai] = coll[i];
                trace[i] = ai;
            } else {
                int lb = binarySearch(answer, 0, ai, coll[i]);
                answer[lb] = coll[i];
                trace[i] = lb;
            }
        }
        int j = ai;
        for (int i = N-1; i >= 0; --i) {
            if (trace[i] == j) {
                answer[j--] = coll[i];
            }
        }
        String ans =
            Arrays.stream(answer)
                    .limit(ai+1)
                    .mapToObj(Integer::toString)
                    .collect(Collectors.joining(" "));

        System.out.println(ai+1);
        System.out.println(ans);
    }

    static int binarySearch(int[] coll, int low, int high, int goal) {
        int cur = (low + high) / 2 + 1;

        if (low == high) cur = low;

        if (coll[cur] == goal) {
            return cur;
        } else if (coll[cur-1] == goal) {
            return cur-1;
        } else if (coll[cur-1] > goal) {
            return binarySearch(coll, low, cur-1, goal);
        } else if (coll[cur] < goal) {
            return binarySearch(coll, cur+1, high, goal);
        } else {
            return cur;
        }
    }
}
