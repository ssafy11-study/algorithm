// Subject: Study of Algorithm with SSAFY
// ProblemNo: 1074
// Language: JAVA
// Author: KimKangjin

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int start, tmp, len, div;
	private static void finder(int size, int r, int c) {
		if (size == 1) {
			System.out.println(start+(r*2)+c);
			return;
		}
		len = (int)Math.pow(2,size);
		tmp = (int)Math.pow(len,2);
		div = (int)Math.pow(2, size-1);
		if (r < len/2 && c < len/2) {
			// div 1
			start += (tmp/4)*0;
			finder(size-1,r,c);
		} else if ( r< len/2 && c >= len/2) {	
			// div 2
			start += (tmp/4)*1;
			finder(size-1,r,c-div);
		} else if (r>= len/2 && c < len/2) {
			// div 3
			start += (tmp/4)*2;
			finder(size-1,r-div,c);
		} else if (r>= len/2 && c>= len/2) {
			// div 4
			start += (tmp/4)*3;
			finder(size-1,r-div,c-div);
		}
	}

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// input testCase
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		start = 0;
		finder(N,r,c);
		
		
	}
}
