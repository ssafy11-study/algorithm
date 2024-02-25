package 알고리즘_스터디._5주차.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11053 {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] array = new int[N];
        int[] answer = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        answer[0] = array[0];
        int counter = 1;
        for (int i = 0; i < N; i++) {
            int targetPosition = Arrays.binarySearch(answer, 0, counter, array[i]);
            if (targetPosition < 0) {
                targetPosition = Math.abs(targetPosition + 1);
            }
            answer[targetPosition] = array[i];

            if (targetPosition == counter) {
                counter++;
            }

        }
        System.out.println(counter);

    }

}
