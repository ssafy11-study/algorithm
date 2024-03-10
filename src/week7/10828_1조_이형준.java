import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10828 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch(command) {
			case "push" :
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "top" :
				if (stack.isEmpty()) System.out.println(-1);
				else System.out.println(stack.peek());
				break;
			case "size" :
				System.out.println(stack.size());
				break;
			case "empty" :
				if(stack.isEmpty()) System.out.println(1);
				else System.out.println(0);
				break;
			case "pop" :
				if(stack.isEmpty()) System.out.println(-1);
				else System.out.println(stack.pop());
				break;
			}
		}
	}

}
