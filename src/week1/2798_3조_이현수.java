package study;

import java.util.ArrayList;
import java.util.Scanner;
public class Black {
    // 이현수
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> cardVal = new ArrayList<Integer>();
        int cardNum = scan.nextInt();
        int target = scan.nextInt();
        for(int i = 0; i < cardNum; i++) {
            cardVal.add(scan.nextInt());
        }
        int max = 0;
        int sum = 0;
        for(int i = 0; i < cardVal.size()-2; i++) {
            for(int j = i+1; j < cardVal.size()-1; j++) {
                for(int k = j+1; k < cardVal.size(); k++) {
                    sum = cardVal.get(i) + cardVal.get(j) + cardVal.get(k);
                    if(sum == target) {
                        max = sum;
                        break;
                    }
                    else if(sum <= target && max <= sum) {
                        max = sum;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
