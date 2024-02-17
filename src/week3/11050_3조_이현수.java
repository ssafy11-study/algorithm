package study;
import java.util.Scanner;
public class _11050_3조_이현수 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();

        int up = 1;
        int down = 1;

        for (int i = N; i > N-K; i--) {
            up *= i;
        }

        for (int i = 1; i <= K; i++) {
            down *= i;
        }
        System.out.println(up / down);
        scan.close();
    }
}
