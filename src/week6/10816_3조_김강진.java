import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int n=0;n<N;n++) {
			int key = Integer.parseInt(st.nextToken());
			map.put(key,  map.getOrDefault(key, 0)+1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		StringBuilder stringBuilder = new StringBuilder();
		
		for (int m=0;m<M;m++) {
			stringBuilder.append(map.getOrDefault(Integer.parseInt(st.nextToken()),0)).append(' ');
		}
		System.out.println(stringBuilder);

	}
}
