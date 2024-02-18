import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static int[] arr;
	static Set<Integer> set = new HashSet<>();
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			set.add(arr[i]);
		}
		
		Object[] sorted = set.stream().sorted().toArray();
		
		for(int i=0;i<N;i++) {
			sb.append(Arrays.binarySearch(sorted, arr[i])).append(" ");
		}
		
		System.out.println(sb);
	}
}
