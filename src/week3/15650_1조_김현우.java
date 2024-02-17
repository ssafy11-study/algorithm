import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	static int src[], tgt[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		src = new int[N];
		tgt = new int[M];
		for(int i = 1; i <= N; i++) {
			src[i-1] = i;
		}
		comb(0,0);
		System.out.println(sb);
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == tgt.length) {
			for(int i = 0; i < tgt.length; i++) {
				sb.append(tgt[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = srcIdx; i < src.length; i++) {
			tgt[tgtIdx] = src[i];
			comb(i+1,tgtIdx+1);
		}
	}

}
