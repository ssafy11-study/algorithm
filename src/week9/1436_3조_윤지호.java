import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        int temp = 0;
        String n = "";
        while(count < N) {
            n = "" + temp;
            temp++;
            if(n.contains("666")) {
                count++;
            }
        }
        System.out.println(--temp);
    }
}