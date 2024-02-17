import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	// 이창현
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue queue = new PriorityQueue();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());			
			if(num == 0) {
				if(queue.isEmpty()) {
					System.out.println(0);
				} else {	
					System.out.println(queue.poll());
				}
			} else {
				queue.add(num);
			}
		}
	
	}
}