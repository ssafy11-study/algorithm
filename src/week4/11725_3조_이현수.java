package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _11725_3조_이현수 {
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        arr = new ArrayList[N+1];
        for(int i = 0; i < arr.length; i++) arr[i] = new ArrayList<>();

        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            arr[n1].add(n2);
            arr[n2].add(n1);
        }

//        for(int i = 0; i <= N; i++){
//            System.out.print("[" + i + "]: ");
//            for(int j = 0; j < arr[i].size(); j++){
//                System.out.print(arr[i].get(j) + " ");
//            }
//            System.out.println();
//        }

        DFS(1, 0);
        for(int i = 2; i < arr.length; i++) sb.append(arr[i].get(0)).append("\n");
        System.out.print(sb);

    }

    static void DFS(int n, int root){
        if(arr[n].size() == 1 && arr[n].get(0) == root) return;

        for(int i = 0; i < arr[n].size(); i++) if(arr[n].get(i) != root) DFS(arr[n].get(i), n);
        arr[n].clear();
        arr[n].add(root);
    }
}
