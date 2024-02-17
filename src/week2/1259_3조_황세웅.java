import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        while (true) {
            char[] seq = br.readLine().toCharArray();
            if (seq[0] == '0') {
                break;
            }
            sb.append(isPalindrome(seq) ? "yes" : "no");
            sb.append(System.lineSeparator());
        }

        System.out.print(sb);
    }

    static boolean isPalindrome(char[] seq) {
        for (int i = 0; i < seq.length / 2; i++) {
            if (seq[i] != seq[seq.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}