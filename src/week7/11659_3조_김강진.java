import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int m,n;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		arr[0] = 0;
		st = new StringTokenizer(br.readLine());
		
		for (int i=1;i<=n;i++) {
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		int i,j;
		for (int t=0;t<m;t++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			
			sb.append(arr[j]-arr[i-1]).append("\n");
		}
		
		System.out.println(sb);
	}

}