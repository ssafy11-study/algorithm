import java.io.*;
import java.util.*;

public class Main {
    static int N, S;
    static int[] arr;
    static Map<Integer, Integer> map = new HashMap<>();
    static long answer = 0;
    static void search2(int depth, int end,int sum){
        if(depth == end) {
            answer += map.getOrDefault(S - sum, 0);
            return;
        }
        search2(depth + 1, end, sum);
        sum += arr[depth];
        search2(depth + 1, end, sum);
    }
    static void search(int depth, int end, int sum){
        if(depth == end){
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            return ;
        }
        search(depth + 1, end,sum);
        sum += arr[depth];
        search(depth + 1, end, sum);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int end = N / 2;
        search(0,end,0);

        search2(end, N,0);

        System.out.println(S == 0 ? answer - 1 : answer);
    }
}
