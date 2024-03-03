import java.util.ArrayList;
import java.util.Scanner;
public class _1978_3조_이현수 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int cnt = 0;
        int stack = 0;
        int num = scan.nextInt();
        for(int i = 0; i < num; i++) {
            arr.add(scan.nextInt());
        }
        for(int i = 0; i < num; i++) {
            for(int j = 1; j < arr.get(i).intValue(); j++) {
                if(arr.get(i) % j == 0) stack++;
            }
            if(stack == 1) cnt++;
            stack = 0;
        }
        System.out.println(cnt);
    }
}