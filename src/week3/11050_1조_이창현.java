import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	//이창현
	static int n, c;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		System.out.println( fac(n) / ( fac(n-c) * fac(c) ));
	}	
	
	static int fac(int n) {
		if(n == 1 || n == 0) {
			return 1;
		}
		return n*fac(n-1);
	}
}
