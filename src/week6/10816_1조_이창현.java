import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static Map<Integer, Integer> map = new HashMap<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int key = Integer.parseInt(st.nextToken());
			if(!map.containsKey(key)) {
				map.put(key, 1);
			} else {
				int value = map.get(key);
				map.replace(key, value + 1);
			}
		}
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int key = Integer.parseInt(st.nextToken());
			int value = 0;
			
			if(map.containsKey(key)) {
				value = map.get(key);
			}
			
			sb.append(value).append(" ");
		}
		
		System.out.println(sb);
		
	}

}
