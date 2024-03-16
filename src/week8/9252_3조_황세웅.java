import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static String S1, S2;
    static int[][] dp;
    static int r, c;

    public static void main(String[] args) throws IOException {
        S1 = br.readLine();
        S2 = br.readLine();

        dp = new int[S1.length() + 1][S2.length() + 1];
        for (int i = 1; i < S1.length() + 1; i++) {
            for (int j = 1; j < S2.length() + 1; j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        r = S1.length();
        c = S2.length();

        Deque<Character> stack = new ArrayDeque<>();
        while (r > 0 && c > 0) {
            if (dp[r - 1][c] == dp[r][c]) r--;
            else if (dp[r][c - 1] == dp[r][c]) c--;
            else {
                stack.push(S1.charAt(r - 1));
                r--;
                c--;
            }
        }

        System.out.println(stack.size());
        while (!stack.isEmpty()) sb.append(stack.pop());
        System.out.print(sb);
    }
}
