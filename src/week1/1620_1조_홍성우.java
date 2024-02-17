package 알고리즘_스터디._1주차.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _1620 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> nameMap = new HashMap<>();
        String[] numberArray = new String[N + 1];

        for (int i = 1; i <= N; i++) {
            String name = bf.readLine();
            nameMap.put(name, i);
            numberArray[i] = name;
        }

        for (int i = 0; i < M; i++) {
            String userInput = bf.readLine();
            boolean inputChecker = Character.isDigit(userInput.charAt(0));

            if (inputChecker) {
                System.out.println(numberArray[Integer.parseInt(userInput)]);
            } else {
                System.out.println(nameMap.get(userInput));
            }
        }
    }
}