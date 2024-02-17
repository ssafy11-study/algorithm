package study;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _3211_3조_이현수 {
    static int answer = 1;
    static int[] arr;
    static int N;

    static void solution(){
        Arrays.sort(arr);
        while(answer <= N && arr[answer - 1] + 1 > answer) answer = arr[answer-1] + 1;
        System.out.print(answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for(int i = 0; i < N; i++){
            int group = Integer.parseInt(br.readLine());
            arr[i] = group;
        }

        solution();
    }
}

