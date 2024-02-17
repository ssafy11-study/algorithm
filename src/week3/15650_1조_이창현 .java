import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	// 이창현
	static int N, M;
	static int[] arr, result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[M];
		for (int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		
		comb(0,0);
		
	}
	
	static void comb(int arrIdx, int resultIdx) {
		if(resultIdx == result.length) {
			
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		
		for (int i = arrIdx; i < arr.length; i++) {
			result[resultIdx]=arr[i];
			comb(i+1, resultIdx+1);
		}
	}

}
