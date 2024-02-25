import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// 이창현
	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			sb.append(search(Integer.parseInt(st.nextToken()))).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int search(int num) {
		int first = 0;
		int last = arr.length - 1;
		
		while(first <= last) {
			int half = (first + last) / 2;
			
			if(num < arr[half]) {
				last = half - 1;
			}
			
			else  if(num > arr[half]){
				first = half + 1;
			}
			
			else {
				return 1;
			}
		}
		
		return 0;
	}
}