import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	
	static StringBuilder preBuilder = new StringBuilder();
	static StringBuilder inBuilder = new StringBuilder();
	static StringBuilder postBuilder = new StringBuilder();
	
	static int[][] tree;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		tree = new int[n][2];
		visited = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int vertex = st.nextToken().charAt(0) - 65;
			int left = st.nextToken().charAt(0) - 65;
			int right = st.nextToken().charAt(0) - 65;

			// . -> -19
			if (left != -19) {
				tree[vertex][0] = left;
			}
			if (right != -19) {
				tree[vertex][1] = right;
			}
		}
		
		traversal(0);
		System.out.println(preBuilder);
		System.out.println(inBuilder);
		System.out.println(postBuilder);
	}
	
	static void traversal(int vertex) {
		if (visited[vertex]) {
			return;
		}
		visited[vertex] = true;
		preBuilder.append((char)(vertex + 65));
		traversal(tree[vertex][0]);
		inBuilder.append((char)(vertex + 65));
		traversal(tree[vertex][1]);
		postBuilder.append((char)(vertex + 65));
	}
}
