import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		List<Dot> list = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {					// 점 입력
			st = new StringTokenizer(br.readLine());
			list.add(new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list, (a, b) -> (a.x == b.x) ? (a.y - b.y) : (a.x - b.x));
		
		for (Dot dot : list) {
			System.out.println(dot.x + " " + dot.y);
		}
	}
}

class Dot {
	int x;
	int y;
	
	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}