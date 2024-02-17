// Subject: Study of Algorithm with SSAFY
// ProblemNo: 19585
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {

	static class Node{
		boolean ep;
		Node[] next;
		Node(){
			next = new Node[26]; ep = false;
			for(int i = 0; i < 26; i++) next[i] = null;
		}
	}

	static final int MX = 100000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
	static int N, M, K, v[];
	static Node head, tail;
	static String s;
    static HashSet<String> S;
    
    static void insert(Node n) {
		for(int i = 0; i < s.length(); i++) {
			int tar = s.charAt(i) - 'a';
			if(n.next[tar] == null) n.next[tar] = new Node();
			n = n.next[tar];
		}
		n.ep = true;
	}
	
	static boolean search(Node n, int idx) {
		for(int i = 0; i < s.length(); i++) {
			Node tar = n.next[s.charAt(i) - 'a'];
			if(tar == null) return false;
			n = tar;
			if(n.ep && S.contains(s.substring(i + 1))) return true;
		}
		return false;
	}
	
    public static void main(String[] args) throws Exception{
        head = new Node();
		tail = new Node();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			s = br.readLine();
			insert(head);
		}
		S = new HashSet(M);
		for(int i = 0; i < M; i++) {
			s = br.readLine();
			S.add(s);
		}
		
		K = Integer.parseInt(br.readLine());
		for(int i = 1; i <= K; i++) {
			s = br.readLine();
			boolean res = search(head, i);
            bw.write(res? "Yes\n":"No\n");
		}
        bw.flush();
        bw.close(); 
    }
}



