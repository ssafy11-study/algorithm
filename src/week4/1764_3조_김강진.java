import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Set<String> nl = new HashSet<>();
		Set<String> ns = new HashSet<>();
		for(int i=0;i<n;i++) {
			nl.add(br.readLine());
		}
		
		for(int i=0;i<m;i++) {
			ns.add(br.readLine());
		}
		
		nl.retainAll(ns);
		
		ArrayList<String> res = new ArrayList<>(nl);
		
		Collections.sort(res);
		
		sb.append(res.size()).append("\n");
		
		for(int i=0;i<res.size();i++) {
			sb.append(res.get(i)).append("\n");
		}
		
		
		System.out.println(sb);
		
	}
	
}
