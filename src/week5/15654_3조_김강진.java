import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n,m,tgt[],src[];
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    
	    src = new int[n];
	    visited = new boolean[n];
	    tgt = new int[m];
	    
	    st = new StringTokenizer(br.readLine());
	    for (int i=0;i<n;i++) {
	    	src[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    Arrays.sort(src);
    
	    perm(0);
	    System.out.println(sb);
	}
	
	static void perm(int tgtIdx) {
		if (tgtIdx == m) {
			for (int i=0;i<tgtIdx;i++) {
				sb.append(tgt[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i =0;i<n;i++) {
			if (visited[i]) continue;
			tgt[tgtIdx] = src[i];
			visited[i] = true;
			perm(tgtIdx+1);
			visited[i] = false;
		}
	}
	
}