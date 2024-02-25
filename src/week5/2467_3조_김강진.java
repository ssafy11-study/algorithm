import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int N,min,lMin,rMin;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lIdx = 0; // 음수
        int rIdx = arr.length-1;
        while (true){
            if (Math.abs(arr[lIdx]) == Math.abs(arr[rIdx])){
                lMin = lIdx;
                rMin = rIdx;
                break;
            } else if ((arr[lIdx] + arr[rIdx]) < 0){ // 두개 합이 음수인 경우 lIdx를 증가
                if (Math.abs(arr[lIdx] + arr[rIdx]) <= min){
                    lMin = lIdx;
                    rMin = rIdx;
                    min = Math.abs(arr[lIdx] + arr[rIdx]);
                }
                lIdx++;
            } else if ((arr[lIdx] + arr[rIdx]) > 0){
                if (Math.abs(arr[lIdx] + arr[rIdx]) <= min){
                    lMin = lIdx;
                    rMin = rIdx;
                    min = Math.abs(arr[lIdx] + arr[rIdx]);
                }
                rIdx--;
            }

            if (rIdx - lIdx < 1) break;
        }

        System.out.println(arr[lMin]+" "+arr[rMin]);

    }
}
