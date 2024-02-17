import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	// 이창현
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			char[] arr = str.toCharArray();
			int num = Integer.parseInt(str);

			if(num==0) {	// 값이 0이면 종료
				break;
			}
			
			int result = 0;
			int len = arr.length;
			
			for(int i = 0; i < len / 2; i++) {
				if(arr[i] != arr[len-1-i]) {
					result = 1;
				}
			}
			
			if(result==0) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
	
}