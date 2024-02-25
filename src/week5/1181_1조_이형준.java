import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
 
 
public class Main {
	public static void main(String[] args) throws IOException {
    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
 
		String[] arr = new String[N];
 
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				} 
				else {
					return s1.length() - s2.length();
				}
			}
		});
 
		StringBuilder sb = new StringBuilder();
 
		sb.append(arr[0]).append('\n');
		
		for (int i = 1; i < N; i++) {
			if (!arr[i].equals(arr[i - 1])) {
				sb.append(arr[i]).append('\n');
			}
		}
		System.out.println(sb);
	}
 
}