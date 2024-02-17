import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> q = new LinkedList<>();
		
		int qSize = 0;
		
		for (int n=0;n<N;n++) {
			String[] str = br.readLine().split(" ");
			String cmd = str[0];
			switch (cmd) {
			case "push":
				q.add(Integer.parseInt(str[1]));
				qSize++;
				break;
			case "pop":
				if (qSize >0) {
					System.out.println(q.pop());
					qSize--;
				} else {
					System.out.println(-1);
				}
				break;
			case "size":
				System.out.println(qSize);
				break;
			case "empty":
				if (qSize > 0) {
					System.out.println(0);
				} else {
					System.out.println(1);
				}
				break;
			case "front":
				if (qSize > 0) {
					System.out.println(q.getFirst());
				} else {
					System.out.println(-1);
				}
				break;
			case "back":
				if (qSize > 0) {
					System.out.println(q.getLast());
				} else {
					System.out.println(-1);
				}
				break;
			}
		}
	}
}
