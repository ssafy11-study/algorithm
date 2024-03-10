import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                if(q.peek() == null) {
                    System.out.println(0);
                }
                else {
                    System.out.println(q.poll());
                }
            }
            else {
                q.add(num);
            }
        }
    }
}