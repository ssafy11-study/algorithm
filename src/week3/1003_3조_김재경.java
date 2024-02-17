import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Main {

    static int zeroMap[] = new int[41];
    static int oneMap[] = new int[41];

    static int zero = 0;
    static int one =0 ;
    static int N ;
    static void fibo(int n){
        if(n==0) {
           zeroMap[0] = 1; //zero 증가
            return;
        }else if(n==1){
            //one 증가
            oneMap[1] = 1;
            return;
        }else {
            if(zeroMap[n-1] > 0 && oneMap[n-1] >0) {
                zeroMap[n] = zeroMap[n-1] + zeroMap[n-2];
                oneMap[n] = oneMap[n-1] + oneMap[n-2];
                return;
            }
            fibo(n-1);
            fibo(n-2);
            zeroMap[n] = zeroMap[n-1] + zeroMap[n-2];
            oneMap[n] = oneMap[n-1] + oneMap[n-2];
        }
    }
    public static void main(String[] args) throws IOException {
//        fiboMap[1] =1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt( br.readLine());
        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            zero = 0;
            one = 0;
            fibo(n);
            System.out.println(zeroMap[n]+ " " + oneMap[n]);
        }
    }
}
