import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 2164_3조_이형준 {
	static Deque<Integer> queue = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for(int i = 1; i<=N; i++) {
			queue.offer(i);
		}
		int num = 0;
//		System.out.println(queue);
		while(queue.size() !=1 ) {
			queue.poll();
			num = queue.poll();
			queue.offer(num);
			
		}
		System.out.println(queue.poll());
	}

}