import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> queue = new ArrayDeque<>();
		
		int N = Integer.parseInt(br.readLine());
		
		
		for(int i = 0; i <N; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine()); 
		    String command = st.nextToken();
				switch(command) {
				case "push" : 
					int num = Integer.parseInt(st.nextToken());
					queue.offer(num);
					//System.out.println(num);
					break;
				case "pop" : 
					if(queue.size() == 0) {System.out.println(-1); }else {System.out.println(queue.poll());}
					break;
				case "size" : 
					System.out.println(queue.size());
					break;
				case "empty" :
					if(queue.isEmpty()) {
						System.out.println(1);
					} else {
						System.out.println(0);
					}
					break;
				case "front" :
					if(queue.size() == 0) {
						System.out.println(-1);
					} else {
						System.out.println(queue.peekFirst());
					}
					break;
				case "back" :
					if(queue.size() == 0) {
						System.out.println(-1);
					} else {
						System.out.println(queue.peekLast());
					}
					break;
				}
			
		}
		
		
	}
}