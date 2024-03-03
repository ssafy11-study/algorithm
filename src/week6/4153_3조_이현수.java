import java.util.Scanner;

public class _4153_3조_이현수 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int[] a = new int[3];
            int max = 0, cnt = 0, sum = 0;
            for(int i = 0; i < a.length; i++) {
                if(i == 0) max = a[0];
                a[i] = scan.nextInt();
                if(max < a[i]) {
                    max = a[i];
                    cnt = i;
                }
            }
            for(int i = 0; i < 3; i++) {
                if(i == cnt) {}
                else {
                    sum += a[i] * a[i];
                }
            }

            if(a[0] != 0 || a[1] != 0 || a[2] != 0) {
                if(max * max == sum) System.out.println("right");
                else System.out.println("wrong");
            }
            else {

            }
        }
    }

}
