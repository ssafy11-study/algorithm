import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _18870 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortedArray = Arrays.stream(array).distinct().sorted().toArray();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < sortedArray.length; i++) {
            hashMap.put(sortedArray[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            sb.append(hashMap.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}
