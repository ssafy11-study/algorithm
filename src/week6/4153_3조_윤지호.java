import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int[] input = new int[3];
            StringTokenizer st = new StringTokenizer(br.readLine());
            input[0] = Integer.parseInt(st.nextToken());
            input[1] = Integer.parseInt(st.nextToken());
            input[2] = Integer.parseInt(st.nextToken());

            Arrays.sort(input);

            if(input[0] == 0 ) break;

            if(Math.pow(input[2], 2) == Math.pow(input[0], 2) + Math.pow(input[1], 2)) {
                System.out.println("right");
            }else {
                System.out.println("wrong");
            }
        }
    }
}