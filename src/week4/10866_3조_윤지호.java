import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static Deque<Integer> deque = new ArrayDeque<>();
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int num = 0;
            if(st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
            }
            switch (cmd) {
                case "push_back": push_back(num); break;
                case "push_front": push_front(num); break;
                case "front": front(); break;
                case "back":  back(); break;
                case "pop_front": pop_front(); break;
                case "pop_back": pop_back(); break;
                case "size": size();  break;
                case "empty": empty(); break;
            }
        }
        System.out.println(sb);
    }

    static void push_front(int x) {deque.offerFirst(x);}
    static void push_back(int x) {deque.offerLast(x);}
    static void pop_front() {if(deque.isEmpty()){sb.append(-1).append("\n");}else{sb.append(deque.pollFirst()).append("\n");}}
    static void pop_back() {if(deque.isEmpty()){sb.append(-1).append("\n");}else {sb.append(deque.pollLast()).append("\n");}}
    static void size() {sb.append(deque.size()).append("\n");}
    static void empty() {if(deque.isEmpty()){sb.append(1).append("\n");}else {sb.append(0).append("\n");}}
    static void front() {if(deque.isEmpty()){sb.append(-1).append("\n");}else{sb.append(deque.peekFirst()).append("\n");}}
    static void back() {if(deque.isEmpty()){sb.append(-1).append("\n");}else{sb.append(deque.peekLast()).append("\n");}}
}