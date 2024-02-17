import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//이창현
	static int N, M;
	static char[][] board, src, src2;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		src = new char[N][M];
		src2 = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		if(board[0][0]=='B') {		// 첫 값이 B일때
			for (int i = 1; i < N; i+=2) {
				for (int j = 1; j < M; j+=2) {
					src[i-1][j-1] = 'B';
					src[i-1][j] = 'W';
					src[i][j-1] = 'W';
					src[i][j] = 'B';
					src2[i-1][j-1] = 'W';
					src2[i-1][j] = 'B';
					src2[i][j-1] = 'B';
					src2[i][j] = 'W';
				}
			}
		}else {
			for (int i = 1; i < N; i+=2) {
				for (int j = 1; j < M; j+=2) {
					src[i-1][j-1] = 'W';
					src[i-1][j] = 'B';
					src[i][j-1] = 'B';
					src[i][j] = 'W';
					src2[i-1][j-1] = 'B';
					src2[i-1][j] = 'W';
					src2[i][j-1] = 'W';
					src2[i][j] = 'B';
				}
			}
		}
		
		
		for (int i = 0; i <= N-8; i++) {
			for (int j = 0; j <= M-8; j++) {
				a(i, j, src);
				a(i, j, src2);
			}
		}
		System.out.println(result);
		
	}
	
	static void a(int i, int j, char[][] arr) {
		int count = 0;
		for (int i2 = 0; i2 < 8; i2++) {
			for (int j2 = 0; j2 < 8; j2++) {
				if(board[i2+i][j2+j]==arr[i2][j2]) {
					continue;
				} else {
					count++;
				}
			}
		}
		result = result<count ? result : count;	
	}
}