import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        int a, b, c;
        while (true) {
            a = user.nextInt();
            b = user.nextInt();
            c = user.nextInt();
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            if ((a * a) + (b * b) == (c * c)) {
                System.out.println("right");
            } else if ((a * a) + (c * c) == (b * b)) {
                System.out.println("right");
            } else if ((a * a) == (b * b) + (c * c)) {
                System.out.println("right");
            }
            else {
                System.out.println("wrong");
            }
        }
    }
}