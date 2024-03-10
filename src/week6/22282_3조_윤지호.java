import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static int[] input;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(input);

		int result = 0;
		for (int i = 0; i < N; i++) {
			while (input[i] >= result && input.length - i >= result) {
				result++;
			}
		}
		System.out.println(result - 1);
	}
}