package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _15663_3조_이현수 {
    static int[] arr;
    static int N, M;
    static int[] answer;
    static int[] vtd;
    static StringBuilder sb = new StringBuilder();
    static HashMap<String, Integer> duplicateCheckedMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        answer = new int[M];
        vtd = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        dicComb(0, answer);

        System.out.print(sb);
    }

    static void dicComb(int L, int[] answer){
        if(L == M){
            String str = "";
            for(int i = 0; i < answer.length; i++) str += String.valueOf(answer[i]) + ",";
            if(duplicateCheckedMap.putIfAbsent(str, 1) == null){
                for(int x : answer) sb.append(x).append(" ");
                sb.append("\n");
            }
            return;
        }

        for(int i = 0; i < N; i++){
            if(vtd[i] != 1){
                vtd[i] = 1;
                answer[L] = arr[i];
                dicComb(L+1, answer);
                vtd[i] = 0;
            }

        }
    }
}
