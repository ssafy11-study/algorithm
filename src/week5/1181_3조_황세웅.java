import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length());
        for (int i = 0; i < N; i++) {
        	String input = br.readLine();
        	if (set.add(input)) pq.offer(input);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
        	sb.append(pq.poll()).append("\n");
        }
        System.out.println(sb);
    }
}