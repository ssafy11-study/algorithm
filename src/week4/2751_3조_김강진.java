import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i=0;i<n;i++) {
			q.add(Integer.parseInt(br.readLine()));
		}
		
		for(int i=0;i<n;i++) {
			sb.append(q.poll()).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}
