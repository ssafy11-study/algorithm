import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 이창현
	static int N, num, bitMask;
	static String method;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			method = st.nextToken();
			if(st.hasMoreTokens()) {
				num = Integer.parseInt(st.nextToken());
			}
			switch (method) {
				case "add":
					add(num);
					break;
				case "remove":
					remove(num);
					break;
				case "check":
					check(num);
					break;
				case "toggle":
					toggle(num);
					break;
				case "all":
					all();
					break;
				case "empty":
					empty();
					break;
			}
		}

		System.out.println(sb);
		
	}
	
	static void add(int x) {
		bitMask |= 1 << x;	
	}
	
	static void remove(int x) {
		bitMask &= ~(1 << x);		
	}
	
	static void check(int x) {
		if((bitMask & 1 << x) == (1 << x)) {
			sb.append(1).append("\n");
		}
		else {
			sb.append(0).append("\n");
		}
		
	}
	
	static void toggle(int x) {
		bitMask ^= 1<<x;	//같으면 1, 다르면 0
	}
	
	static void all() {
		bitMask = (1<<21) - 1;
	}
	
	static void empty() {
		bitMask = 0;
	}
}
