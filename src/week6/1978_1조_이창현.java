import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	
	static int N, result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			int count = 0;
			if(num==1)continue;
			for (int j = 2; j < num; j++) {
				if(num%j==0) {
					count++;
					break;
				}
			}
			if(count==0) {
				result++;
			}
		}
		System.out.println(result);
	}		
}
