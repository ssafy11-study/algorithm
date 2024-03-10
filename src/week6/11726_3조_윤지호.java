import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static Long[] result = new Long[1001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        result[1] = 1L;
        result[2] = 2L;
        for (int i = 3; i < 1001; i++) {
            result[i] = result[i - 1] + result[i - 2];
            result[i] %= 10007;
        }
        System.out.println(result[N]);
    }
}