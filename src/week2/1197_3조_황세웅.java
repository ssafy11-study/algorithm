import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	
	static int[] parents;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		parents = new int[v + 1];
		for (int i = 0; i < v + 1; i++) {
			parents[i] = i;
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			pq.add(new Edge(v1, v2, weight));
		}
		
		int acc = 0;
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (union(curr.v1, curr.v2)) {
				acc += curr.weight;
			}
		}
		System.out.println(acc);
	}
	
	static int find(int vertex) {
		if (parents[vertex] == vertex) {
			return vertex;
		}
		return find(parents[vertex]);
	}
	
	static boolean union(int v1, int v2) {
		int p1 = find(v1);
		int p2 = find(v2);
		
		if (p1 == p2) {
			return false;
		}
		
		if (p1 < p2) {
			parents[p2] = p1;
			return true;
		}
		parents[p1] = p2;
		return true;
	}
	
	static class Edge {
		int v1;
		int v2;
		int weight;
		
		public Edge(int v1, int v2, int weight) {
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}
	}
}