import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[] input, origin;
    static int N;
    static Map<Integer, Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        origin = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            origin[i] = input[i];
        }
        
        Arrays.sort(input);

        int rank = 0;
        for(int n : input){
            if(!map.containsKey(n)) {
                map.put(n, rank++);
            }
        }

        for(int n : origin) {
            sb.append(map.get(n)).append(" ");
        }
        System.out.println(sb);
    }
}