import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static Deque<Integer> q,all;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int M = Integer.parseInt(br.readLine());
		q = new ArrayDeque<>();
		
		int num;
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "add":
				num = Integer.parseInt(st.nextToken());
				if (q.contains(num)) break;
				q.offer(num);
				break;
			case "remove":
				num = Integer.parseInt(st.nextToken());
				if (q.isEmpty()) break;
				q.remove(num);
				break;
			case "check":
				num = Integer.parseInt(st.nextToken());
				if(q.contains(num)) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				
				break;
			case "toggle":
				num = Integer.parseInt(st.nextToken());
				if(q.contains(num)) {
					q.remove(num);
				} else {
					q.offer(num);
				}
				break;
			case "all":
				q.clear();
				for (int j=1;j<=20;j++) {
					q.offer(j);
				}
				break;
			case "empty":
				q.clear();
				break;
			}
		}
		System.out.println(sb);
	}
	
	 
}
