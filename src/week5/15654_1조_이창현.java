import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// 이창현
	static int N, M;
	static int[] src, tgt;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		src = new int[N];
		tgt = new int[M];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(src);
		perm(0);
		System.out.println(sb);
	}
	
	static void perm(int idx) {
		if(idx == M) {
			for (int i = 0; i < tgt.length; i++) {
				sb.append(tgt[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < src.length; i++) {
			if(visited[i]) continue;
			
			tgt[idx] = src[i];
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;
		}
	}
}
