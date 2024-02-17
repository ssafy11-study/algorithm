import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int [][] board;
	static StringTokenizer st;
	
	static int resW,resB;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		board = new int[n][n];
		
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<n;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divider(n,0,0);
		System.out.println(resW+" "+resB);
	}
	
	static void divider(int size, int r, int c) {
		if (checker(size,r,c)) {
			if (board[r][c] == 0)resW++;
			else resB++;
			return;
		} else {
			int div = size/2;
			// 1사분면
			divider(size/2, r, c);
			// 2사분면
			divider(size/2, r+div, c);
			// 3사분면
			divider(size/2, r, c+div);
			// 4사분면
			divider(size/2, r+div, c+div);
		}
		
	}
	
	static boolean checker(int size, int r, int c) {
		int color = board[r][c];
		for (int i=r;i<r+size;i++) {
			for (int j=c;j<c+size;j++) {
				if (color != board[i][j]) return false;
				}	
		}
		
		return true;
	}
	
}
