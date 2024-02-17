package submit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1463 {

    static int[] arr = new int[1000001];
    int DP(int num){
        if(num < 4 || arr[num] != 0) return arr[num];

        if(num % 6 == 0) arr[num] = Math.min(DP(num /2), DP(num /3)) + 1;
        else if(num % 3 == 0) arr[num] = Math.min(DP(num -1), DP(num /3)) + 1;
        else if(num % 2 == 0) arr[num] = Math.min(DP(num -1), DP(num /2)) + 1;
        else arr[num] = DP(num - 1) + 1;

        return arr[num];
    }
    public static void main(String[] args) throws IOException{
        S1463 m = new S1463();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;

        System.out.print(m.DP(num));
    }
}
