import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (k == 0){
            System.out.println(1);
        }
        else{
            int answer = fact(n) / (fact(k) * fact(n-k));
            System.out.println(answer);
        }
    }

    public static int fact(int n){
        if (n == 0){
            return 1;
        }
        if (n == 1){
            return 1;
        }
        else{
            return n*fact(n-1);
        }
    }
}