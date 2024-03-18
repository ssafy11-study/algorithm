import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int answer;
    static StringBuilder sb = new StringBuilder();
    static String[] mbti;
    static String[] checker;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        for (int i = 0; i < testCase; i++) {
            N = Integer.parseInt(bf.readLine());
            mbti = new String[N];
            checker = new String[3];
            answer = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                mbti[j] = st.nextToken();
            }
            if(N > 32){
                sb.append(0).append("\n");
                continue;
            }
            solution(0, 0);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void solution(int start, int count) {
        if (answer == 0) {
            return;
        }

        if (count == 3) {
            int tempAnswer = 0;
            String temp1 = checker[0];
            String temp2 = checker[1];
            String temp3 = checker[2];
            tempAnswer += getCounter(temp1, temp2);
            tempAnswer += getCounter(temp3, temp2);
            tempAnswer += getCounter(temp1, temp3);
            answer = Math.min(tempAnswer, answer);
            return;
        }
        for (int i = start; i < N; i++) {
            checker[count] = mbti[i];
            solution(i + 1, count + 1);
        }
    }

    private static int getCounter(String mbti1, String mbti2) {
        int counter = 0;
        for (int i = 0; i < 4; i++) {
            if (mbti1.charAt(i) != mbti2.charAt(i)) {
                counter += 1;
            }
        }
        return counter;
    }
}

