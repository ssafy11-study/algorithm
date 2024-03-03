import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_4153 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		while(true) {
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[3];
			
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			arr[2] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(arr);
			if(arr[0] + arr[1] + arr[2] == 0) break;
			if(Math.pow(arr[2], 2) == Math.pow(arr[0], 2) + Math.pow(arr[1], 2)) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
			Arrays.fill(arr, 0);
		}

	}

}
