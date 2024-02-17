import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int result = 1;
        int p = 1;
        for (int i = 0; i < K; i++) {
            result *= N--;
            p *= (K-i);
        }
        System.out.println(result/p);
    }
}