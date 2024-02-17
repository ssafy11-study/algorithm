import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		
		int v1 = gcd(n1, n2);
		int v2 = n1 * n2 / v1;
		
		System.out.println(v1);
		System.out.println(v2);
	}
	
	static int gcd(int n1, int n2) {
		int a = Math.max(n1, n2);
		int b = Math.min(n1, n2);
		int r = b;
		
		while (r != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		
		return a;
	}
}
