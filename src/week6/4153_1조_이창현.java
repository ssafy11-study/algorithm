import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] arr = new int[3];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 3; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			if( arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
				break;
			}
			
			Arrays.sort(arr);
			
			int a = arr[0] * arr[0];
			int b = arr[1] * arr[1];
			int c = arr[2] * arr[2];
			
			if(c == a + b) {
				sb.append("right").append("\n");
			} else {
				sb.append("wrong").append("\n");
			}
		}
		
		System.out.println(sb);
		
		
	}
}
