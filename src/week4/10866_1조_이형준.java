import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		Deque<Integer> deque = new ArrayDeque<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String command;
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			 st = new StringTokenizer(br.readLine());
			 command = st.nextToken();
			 switch(command) {
			 case "push_back" :
				 deque.offerLast(Integer.parseInt(st.nextToken()));
				 break;
				 
			 case "push_front" :
				 deque.offerFirst(Integer.parseInt(st.nextToken()));
				 break;
				 
			 case "pop_front" :
				 if(deque.size() == 0) System.out.println(-1);
				 else System.out.println(deque.pollFirst());
				 break;
			 case "pop_back" :
				 if(deque.size() == 0) System.out.println(-1);
				 else System.out.println(deque.pollLast());
				 break;
			 case "size" :
				 System.out.println(deque.size());
				 break;
			 case "empty" :
				 if(deque.isEmpty()) System.out.println(1);
				 else System.out.println(0);
				 break;
			 case "front" :
				 if(deque.size() == 0) System.out.println(-1);
				 else System.out.println(deque.peekFirst());;
				 break;
			 case "back" :
				 if(deque.size()== 0) System.out.println(-1);
				 else System.out.println(deque.peekLast());;
				 break;
			 }
			 
		}

	}

}