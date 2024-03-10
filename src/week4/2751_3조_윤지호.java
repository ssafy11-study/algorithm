import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] inputs = new int[N];
        for(int i=0; i<N; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(inputs);
        StringBuilder sb = new StringBuilder();
        for(int a:inputs) {
            sb.append(a).append("\n");
        }
        System.out.println(sb);
    }
}