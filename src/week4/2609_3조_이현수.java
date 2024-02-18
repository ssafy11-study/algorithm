package study;
import java.util.ArrayList;
import java.util.Scanner;
public class _2609_3조_이현수 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = scan.nextInt(), num2 = scan.nextInt();
        int myDevideSol = 0, max = num1;
        if(num1 < num2) {
            max = num2;
        }
        ArrayList<Integer> devide_array1 = new ArrayList<Integer>();
        ArrayList<Integer> devide_array2 = new ArrayList<Integer>();

        for(int i = 1; i <= max; i++) {
            if(num1 % i == 0) {
                devide_array1.add(i);
            }
            if(num2 % i == 0) {
                devide_array2.add(i);
            }
        }
        ArrayList<Integer> devide_merge = new ArrayList<Integer>(devide_array1);
        devide_merge.removeAll(devide_array2);
        devide_merge.addAll(devide_array2);
        for(int i = 1; i <= max; i++) {
            if(num1 % i == 0 && num2 % i == 0) myDevideSol = i;
        }
        int myMultiSol = myDevideSol * (num1 / myDevideSol) * (num2 / myDevideSol);

        System.out.println(myDevideSol);
        System.out.println(myMultiSol);
    }
}
