import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	//이창현
	static int N, num;
	static String method;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Deque<Integer> queue = new ArrayDeque<>();
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			method = st.nextToken();
			
			switch(method) {
			case "push":
				num = Integer.parseInt(st.nextToken());
				push(queue, num);
				break;
			case "pop" :
				pop(queue);
				break;
			case "empty" :
				empty(queue);
				break;
			case "front" :
				front(queue);
				break;
			case "back" :
				back(queue);
				break;
			case "size" :
				size(queue);
				break;
				
			}
		}
	}
	
	static void push(Deque queue, int n) {
		queue.offer(n);
	}
	
	static void pop(Deque queue) {
		if( !queue.isEmpty()) {
			System.out.println(queue.pop());
		} else {
			System.out.println(-1);
		}
	}
	
	static void size(Deque queue) {
		System.out.println(queue.size());
	}
	
	static void empty(Deque queue) {
		if (queue.isEmpty()) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
	
	static void front(Deque queue) {
		if( !queue.isEmpty()) {
			System.out.println(queue.peek());
		} else {
			System.out.println(-1);
		}
	}
	
	static void back(Deque queue) {
		if( !queue.isEmpty()) {
			System.out.println(queue.peekLast());
		} else {
			System.out.println(-1);
		}
	}

}
