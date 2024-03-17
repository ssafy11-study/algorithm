import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int target = scan.nextInt();

        int[] coin = new int[size];
        for(int i = 0; i < size; i++){
            coin[i] = scan.nextInt();
        }
        int cnt = size - 1;
        int coinCnt = 0;
        while(target != 0) {
            if(target / coin[cnt] >= 1){
                coinCnt += target / coin[cnt];
                target = target % coin[cnt];

            }
            else{
                cnt--;
            }
        }
        System.out.println(coinCnt);
        
    }
}