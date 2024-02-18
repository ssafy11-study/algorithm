package study;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class _2751_3조_이현수 {
    static int[] sorted;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(br.readLine());
        sorted = new int[size];
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < size; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }

        mergeSort(arr, 0, size - 1);

        for(int i = 0; i < size; i++){
            sb.append(arr.get(i) + "\n");
        }
        System.out.println(sb);
    }

    static void merge(ArrayList<Integer> a, int m, int middle, int n){
        int i,j,k;
        i = m;
        j = middle + 1;
        k = m;

        while(i <= middle && j <= n){
            if(a.get(i) <= a.get(j)){
                sorted[k] = a.get(i);
                i++;
            } else {
                sorted[k] = a.get(j);
                j++;
            }
            k++;
        }
        if(i > middle){
            for(int t = j; t <= n; t++){
                sorted[k] = a.get(t);
                k++;
            }
        }
        if(j > n){
            for(int t = i; t <= middle; t++){
                sorted[k] = a.get(t);
                k++;
            }
        }

        for(int t = m; t <= n; t++){
            a.set(t, sorted[t]);
        }
    }
    static void mergeSort(ArrayList<Integer> a, int m, int n){
        if(m < n){
            int middle = (m+n) / 2;
            mergeSort(a, m, middle);
            mergeSort(a, middle + 1, n);
            merge(a, m, middle, n);
        }
    }
}
