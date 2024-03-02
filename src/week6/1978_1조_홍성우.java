package 알고리즘_스터디._6주차.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _1978 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        while (st.hasMoreTokens()) {
            int temp = Integer.parseInt(st.nextToken());
            if (isPrime(temp)) {
                answer++;
            }

        }
        System.out.println(answer);

    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
