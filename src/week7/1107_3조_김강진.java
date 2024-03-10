import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int M,in,ans;
	static String N;
	static boolean[] nums = new boolean[10]; // t : 고장, f : 사용가능
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = br.readLine();
		M = Integer.parseInt(br.readLine());
		
		if (M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i=0;i<M;i++) {
				in = st.nextToken().charAt(0) - '0';
				nums[in] = true;
			}
		}
		
		ans = Math.abs(Integer.parseInt(N) - 100); // + 혹은 -로 갈 수 있는 경우의 수
		
		if (ans != 0) {
			solution("");
		}
		
		System.out.println(ans);
	}
	
	static void solution(String str){
		for(int i=0;i<10;i++) {
			if(nums[i]) continue;
			String tmpStr = str+(char)(i+'0');
			
			ans = Math.min(ans, Math.abs(Integer.parseInt(N) - Integer.parseInt(tmpStr))+tmpStr.length());
			
			if (tmpStr.length()<6) {
				solution(tmpStr);
			}
		}
	}
}
