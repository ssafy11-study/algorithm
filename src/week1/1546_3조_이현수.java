package study;

import java.util.Scanner;
public class Average {
    // 부울경-3반-이현수
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        double max = 0, re = 0, sum = 0;
        double[] point = new double[num];
        for(int i = 0; i < num; i++) {
            point[i] = scan.nextDouble();
            if(max < point[i]) {
                max = point[i];
            }
        }
        for(int i = 0; i < num; i++) {
            point[i] = point[i] / max * 100;
            sum += point[i];
        }
        re = sum / num;
        System.out.println(re);
    }
}