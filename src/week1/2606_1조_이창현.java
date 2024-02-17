import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 이창현
	static int N;
	static int M;
	
	static int count = 0;
	
	static int[][] arr;
	static boolean[] check;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		
		arr = new int[N+1][N+1];
		check = new boolean[N+1];
		
		for(int i = 0 ; i < M ; i ++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			
			arr[a][b] = arr[b][a] =  1;	
		}
		
			dfs(1);
			
			System.out.println(count-1);
		
		}
	
	public static void dfs(int start) {
		
		check[start] = true;
		count++;
		
		for(int i = 0 ; i <= N ; i++) {
			if(arr[start][i] == 1 && !check[i])
				dfs(i);
		}
		
	}
}
