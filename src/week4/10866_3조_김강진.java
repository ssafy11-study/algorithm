import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;


public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// Input N
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> arr = new LinkedList<>();
		int size = 0;
		
		for (int i=0;i<N;i++) {
			String inputString = br.readLine();
			String[] inputCmd = inputString.split(" ");
			switch (inputCmd[0]) {
			case "push_front":
				arr.addFirst(Integer.parseInt(inputCmd[1]));
				size++;
				break;
			case "push_back":
				arr.add(Integer.parseInt(inputCmd[1]));
				size++;
				break;
			case "pop_front":
				if(size <= 0) {
					System.out.println(-1);
				} else {
					System.out.println(arr.pollFirst());
					size --;
				}
				break;
			case "pop_back":
				if(size <= 0) {
					System.out.println(-1);
				} else {
					System.out.println(arr.pollLast());
					size --;
				}
				break;
			case "size":
				System.out.println(size);
				break;
			case "empty":
				if (size <= 0){
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			case "front":
				if(size <= 0) {
					System.out.println(-1);
				} else {
					System.out.println(arr.peekFirst());
					
				}
				break;
			case "back":
				if(size <= 0) {
					System.out.println(-1);
				} else {
					System.out.println(arr.peekLast());
				}
				break;
			}
		}
	}
}
