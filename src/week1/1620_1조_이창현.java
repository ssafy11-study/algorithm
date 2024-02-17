import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	// 이창현
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		StringTokenizer st = new StringTokenizer(br.readLine());

		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, String> map = new HashMap<>();
		HashMap<String, Integer> strMap = new HashMap<>();
		

		for(int i=1; i<=N; i++) {
			String str = br.readLine();
			map.put(i, str);
			strMap.put(str, i);
		}
		
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			if(str.replaceAll("[0-9]", "").length()==0) {
				int num = Integer.parseInt(str);
				System.out.println(map.get(num));
			} else {
				System.out.println(strMap.get(str));
			}
		}
	}

}
