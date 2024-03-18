import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {
    public static int answer;

    public static int[] board;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(bf.readLine());
        answer = 0;
        board = new int[n];
        dfs(n, 0);
        System.out.println(answer);
        
    }

    public static void dfs(int n, int curr) {
        if (n == curr) {
            answer++;
            return;
        } else {
            for (int i = 0; i < n; i++) {
                board[curr] = i;
                if (isPossible(curr)) {
                    dfs(n, curr + 1);
                }
            }
        }

    }
    public static boolean isPossible(int curr) {
        for (int i = 0; i < curr; i++) {
            if (board[i] == board[curr] || curr - i == Math.abs(board[curr] - board[i])) {
                return false;
            }
        }
        return true;
    }
}