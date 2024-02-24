import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N;
	static int[] seq;
	static List<Integer> lis;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		seq = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		lis = new ArrayList<>();
		for (int e : seq) {
			int idx = lowerBound(e);
			if (idx == -1) lis.add(e);
			else lis.set(idx, e);
		}
		System.out.println(lis.size());
	}
	
	static int lowerBound(int target) {
		int left = -1; // false
		int right = lis.size() - 1; // true
		
		if (lis.isEmpty()) return - 1;
		if (lis.get(right) < target) return -1;
		
		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (lis.get(mid) >= target) right = mid;
			else left = mid;
		}
		
		return right;
	}
}