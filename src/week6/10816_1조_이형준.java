import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10816 {
	static int N, M;
	static int[] arrN, arrM;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		arrN = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arrN);
		
		
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int key = Integer.parseInt(st.nextToken());
			sb.append(upperBound(arrN, key) - lowerBound(arrN, key)).append(" ");
		}

		System.out.println(sb);
	}

	static int lowerBound(int[] arr, int key) {
		int lower = 0;
		int higher = arr.length;

		while (lower < higher) {
			int mid = (lower + higher) / 2;

			if (key <= arr[mid]) {
				higher = mid;
			} else {
				lower = mid + 1;
			}
		}

		return lower;
	}

	static int upperBound(int[] arr, int key) {
		int lower = 0;
		int higher = arr.length;

		while (lower < higher) {
			int mid = (lower + higher) / 2;

			if (key < arr[mid]) {
				higher = mid;
			} else {
				lower = mid + 1;
			}
		}
		return lower;
	}
}
