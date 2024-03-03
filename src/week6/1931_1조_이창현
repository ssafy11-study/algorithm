import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, result;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pq.add(new Node(start, end));
		}
		
		result = 1;
		Node cn = pq.poll();
		int end = cn.end;
		while(!pq.isEmpty()) {
			Node nc = pq.poll();
			if(end <= nc.start) {
				end = nc.end;
				result++;
			}
			
		}
		System.out.println(result);
	}
	
	static class Node implements Comparable<Node>{
		int start, end;
		
		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Node n) {
			if(this.end == n.end) {
				return this.start - n.start;
			} else return this.end - n.end;
		}
	}
}

