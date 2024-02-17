import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static Deque<Integer> queue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = 0;
            String command;

            command = st.nextToken();
            if (st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
            }
            queue(command, num);
        }
        System.out.println(sb);
    }

    static void queue(String cmd, int num) {
        switch(cmd) {
            case("push"): doPush(num); break;
            case("pop"): doPop(); break;
            case("size"): doSize(); break;
            case("empty"): doEmpty(); break;
            case("front"): doFront(); break;
            case("back"): doBack(); break;
        }
        if(!cmd.equals("push")) sb.append("\n");
    }

    static void doPush(int num){
        queue.offer(num);
    }
    static void doPop() {
        if(queue.isEmpty()) {
            sb.append(-1);
        }
        else {
            sb.append(queue.poll());
        }
    }
    static void doSize() {
        sb.append(queue.size());
    }
    static void doEmpty() {
        sb.append(queue.isEmpty() ? 1:0);
    }
    static void doFront() {
        if(queue.isEmpty()) {
            sb.append(-1);
        }
        else {
            sb.append(queue.peekFirst());
        }
    }
    static void doBack() {
        if(queue.isEmpty()) {
            sb.append(-1);
        }else {
            sb.append(queue.peekLast());
        }
    }
}
