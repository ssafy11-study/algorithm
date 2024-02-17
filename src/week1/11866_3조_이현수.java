package study;

import java.util.ArrayList;
import java.util.Scanner;

public class Josephus {
    // 이현수
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int order = scan.nextInt();

        int[] nArr = new int[size];
        int cnt =0;
        int re = -1;
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 1; i <= size; i++) {
            a.add(i);
        }
        while(a.size() != 0){
            for(int i = 0; i < order; i++){
                re++;
                if(re == a.size()) re = 0;
            }
            nArr[cnt] = a.get(re);
            cnt++;
            a.remove(re);
            re--;
        }
        System.out.print("<");
        for (int i = 0; i < nArr.length; i++) {
            if(i == nArr.length - 1) System.out.println(nArr[i] + ">");
            else System.out.print(+nArr[i] + ", ");
        }
    }
}
