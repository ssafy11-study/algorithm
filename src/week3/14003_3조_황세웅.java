import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n;
	static int[] seq;
	static List<Integer> tmp;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		seq = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] idx = new int[n];
		tmp = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			int lowerIdx = lowerBound(seq[i]);
			if (lowerIdx == -1) {
				tmp.add(seq[i]);
				idx[i] = tmp.size() - 1;
				continue;
			}
			tmp.set(lowerIdx, seq[i]);
			idx[i] = lowerIdx;
		}
		
		int lastIdx = tmp.size() - 1;
		int[] lis = new int[tmp.size()];
		
		for (int i = n - 1; i >= 0; i--) {
			if (idx[i] != lastIdx) {
				continue;
			}
			lis[lastIdx--] = seq[i];
			if (lastIdx == -1) {
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(tmp.size()).append("\n");
		
		for (int i = 0; i < tmp.size(); i++) {
			sb.append(lis[i]).append(" ");
		}
		
		System.out.println(sb);
	}
	
	static int lowerBound(int target) {
		int left = 0; // false
		int right = tmp.size() - 1; // true
		int mid = (left + right) / 2;
		
		if (tmp.isEmpty()) {
			return -1;
		}
		if (tmp.get(left) >= target) {
			return 0;
		}
		if (tmp.get(right) < target) {
			return -1;
		}
		
		while (left + 1 < right) {
			if (tmp.get(mid) < target) {
				left = mid;
			} else {
				right = mid;
			}
			mid = (left + right) / 2;
		}
		return right;
	}
}