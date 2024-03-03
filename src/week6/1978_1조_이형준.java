import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1978 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			if(arr[i] == 1) continue;
			for (int j = 2; j <= arr[i]; j++) {
				if(arr[i] == j) cnt++;
				if(arr[i] % j == 0) break;
			}
		}
		
		System.out.println(cnt);
	}

}
