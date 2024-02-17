// Subject: Study of Algorithm with SSAFY
// ProblemNo: 1463
// Language: JAVA
// Author: KimKangjin

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		// input int x
		int X = Integer.parseInt(st.nextToken());
		int [] dp = new int [X+1];
		dp[0] = 0;
		
		for (int i=1;i<=X;i++) {
			dp[i] = dp[i-1]+1;
			if (i%2 == 0) {
				dp[i] = Math.min(dp[i],dp[i/2]+1);
			}
			if (i%3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
		}
		
		System.out.println(dp[X]-1);
		
	}
}
