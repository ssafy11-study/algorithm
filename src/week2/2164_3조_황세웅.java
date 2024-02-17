import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> cards = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            cards.add(i);
        }

        int last = 0;
        while (!cards.isEmpty()) {
            last = cards.poll();
            if (!cards.isEmpty()) {
                last = cards.poll();
                cards.add(last);
            }
        }
        System.out.println(last);
    }
}