package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15650_3조_이현수 { // 조합

    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        answer = new int[M];

        for(int i = 0; i < arr.length; i++){
            arr[i] = i+1;
        }

        comb(0,0);

        System.out.print(sb);
    }

    static void comb(int start, int cnt){
        if(cnt == answer.length) {
            for (int x : answer) sb.append(x).append(" ");
            sb.append("\n");
            return;
        }
        for(int i = start; i < arr.length; i++){
            answer[cnt] = arr[i];
            comb(i + 1, cnt + 1);
        }

    }
}
