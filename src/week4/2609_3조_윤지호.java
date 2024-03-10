import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if (a < b) {
            System.out.println(GCD(b, a));
            System.out.println(LCM(b, a));
        }else{
            System.out.println(GCD(a, b));
            System.out.println(LCM(a, b));
        }

    }

    static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }

    static int LCM(int a, int b) {
        return a * b / GCD(a, b);
    }
}