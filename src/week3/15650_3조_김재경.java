import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] tgt;
	static StringBuilder sb= new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str =br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		tgt = new int[M];
		
		comb(0,0);
		
		System.out.println(sb.toString());
		
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx==M) {
			for(int i=0; i<tgt.length; i++) {
				sb.append(tgt[i]+1).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=srcIdx; i<N; i++) {
			tgt[tgtIdx] = i;
			comb(i+1,tgtIdx+1);
		}
	}
}
