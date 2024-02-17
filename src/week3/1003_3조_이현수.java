package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class _1003_3조_이현수{
    static int[] zero = new int[41];
    static int[] one = new int[41];
    static int max = Integer.MIN_VALUE;;

    static void fibo(int num){
        if (num > max) return;

        if(num == 0){
            zero[num] = 1;
            one[num] = 0;
        }
        else if(num == 1){
            zero[num] = 0;
            one[num] = 1;
        }
        else {
            zero[num] = zero[num-2] + zero[num-1];
            one[num] = one[num-2] + one[num-1];
        }
        num++;
        fibo(num);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            if(max < n) {
                max = n;
                fibo(0);
            }
            sb.append(zero[n] + " " + one[n]).append("\n");
        }
        System.out.print(sb);
    }
}
