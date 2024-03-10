import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	static Deque<Integer> queue = new ArrayDeque<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		while(queue.size() > 1) {
			queue.poll();
			queue.add(queue.poll());
		}
		System.out.println(queue.poll());
	}
}