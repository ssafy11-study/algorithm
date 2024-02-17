import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n,m;
	static int[] nums, tgd;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		nums = new int[n];
		tgd = new int[m];
		for (int i=0;i<n;i++) {
			nums[i] = i+1;
		}

		combi(0,0);
		System.out.println(sb.toString());
	}
	
	public static void combi(int srcIdx, int tgdIdx) {
		if (tgdIdx == m) {
			for (int n: tgd) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		if (srcIdx >= n ) return;
		tgd[tgdIdx] = nums[srcIdx];
		combi(srcIdx+1, tgdIdx+1);
		combi(srcIdx+1, tgdIdx);
	}

}
