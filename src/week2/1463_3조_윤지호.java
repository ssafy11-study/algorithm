import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] lst = new int[1000001];
        lst[2] = 1;
        lst[3] = 1;

        for(int i=4; i<T+1; i++) {
            lst[i] = lst[i-1] + 1;
            if (i%2 == 0) {
                lst[i] = Math.min(lst[i], lst[i/2]+1);
            }
            if (i%3 ==0) {
                lst[i] = Math.min(lst[i], lst[i/3]+1);
            }
        }
        System.out.println(lst[T]);
    }
}
