import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11399_3조_이현수 {
    static int[] people;
    static int[] cumulativeSum;
    int solution(int n){
        Arrays.sort(people);
        cumulativeSum[0] = people[0];
        for(int i = 1; i < cumulativeSum.length; i++){
            cumulativeSum[i] = cumulativeSum[i-1] + people[i];
        }
        // 1 2 3 3 4
        // 1 3 6 9 13

        return Arrays.stream(cumulativeSum).sum();
    }
    public static void main(String[] args) throws IOException {
        _11399_3조_이현수 a = new _11399_3조_이현수();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        cumulativeSum = new int[n];
        people = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) people[i] = Integer.parseInt(st.nextToken());
        System.out.println(a.solution(n));

    }
}
