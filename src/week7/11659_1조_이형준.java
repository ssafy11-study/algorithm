import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr; 
	static int[] sum;
	public static void main(String[] args) throws Exception {
		
		// M : M개의 수가 주어진다는 것
		// N : 반복 횟수
		// arr : 입력받은 M개의 값 저장하는 배열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		sum = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		sum[0] = arr[0]; 
		for (int i = 1; i < N; i++) {
			sum[i] = arr[i] + sum[i-1]; // 부분합
		}
		
//		System.out.println(N);
//		System.out.println(M);
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(sum));
		
		
		for(int i =0; i< M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a == 1) {//입력이 1인데 배열은 0부터 시작함. (1,3)은 3까지 부분합 - 0까지 부분합인데  0까지 부분합은 배열의 범위를 벗어남.
				System.out.println(sum[b-1]);
			}else {
				System.out.println(sum[b-1] - sum[a-2]);
			}
			
			
		}
		//부분합 배열 만들어서 그 구간별로 계산하기
		//부분합을 저장할 배열을 만든다
		
		
		
		
		
	}

}
