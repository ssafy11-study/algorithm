// Subject: Study of Algorithm with SSAFY
// ProblemNo: 2164
// Language: JAVA
// Author: KimKangjin

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> q = new LinkedList<>();
		
		for (int n=1;n<=N;n++) {
			q.add(n);
		}
		
		while(q.size()> 1) {
			q.removeFirst();
			q.add(q.pollFirst());
		}
		
		System.out.println(q.poll());

	}
}
