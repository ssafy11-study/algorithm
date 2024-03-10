import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static String checkVPS(String str) {
		Queue<Character> q = new LinkedList<>();
		Boolean isValid = true;
		
		for (int i=0;i<str.length();i++) {
//			System.out.println(str.charAt(i));
			if (str.charAt(i) == '(') {
				q.add(str.charAt(i));
			} else {
				if (q.isEmpty()) {
					isValid = false;
					return "NO";
				} else {
					q.remove();
				}
			}
			
		}
		
		if (!q.isEmpty()) {
			return "NO";
		}
		return "YES";
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		for (int t=0;t<T;t++) {
			String str = br.readLine();
			System.out.println(checkVPS(str));
		}
		
		
	}
}
