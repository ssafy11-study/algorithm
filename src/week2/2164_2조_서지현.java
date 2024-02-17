import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=n;i++){
            queue.offer(i);
        }
        int answer;
        while (true) {
            if (queue.size() == 1){
                answer = queue.poll();
                break;
            }
            queue.poll();
            if (queue.size() == 1){
                continue;
            }
            int temp = queue.poll();
            queue.offer(temp);
        }
        System.out.println(answer);
    }
}