import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    
    static int N, M, T, ans;
    static List<Integer>[] seq;
    static int[] parents;
    
    public static void main(String[] args) throws IOException {
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	parents = new int[N + 1];
    	for (int i = 0; i < N + 1; i++) {
    		parents[i] = i;
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	T = Integer.parseInt(st.nextToken());
    	
    	for (int t = 0; t < T; t++) {
    		int v = Integer.parseInt(st.nextToken());
    		union(v, 0);
    	}
    	
    	seq = new List[M];
    	for (int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
        	T = Integer.parseInt(st.nextToken());
        	seq[i] = new ArrayList<>();
        	
        	int prev = Integer.parseInt(st.nextToken());
        	seq[i].add(prev);
        	
        	for (int t = 1; t < T; t++) {
        		int curr = Integer.parseInt(st.nextToken());
        		union(curr, prev);
        		seq[i].add(curr);
        		prev = curr;
        	}
    	}
    	
    	A: for (int i = 0; i < M; i++) {
    		for (int v : seq[i]) {
    			if (find(v) == 0) continue A;
    		}
    		ans++;
    	}
    	System.out.println(ans);
    }
    
    static int find(int v) {
    	if (parents[v] != v) parents[v] = find(parents[v]);
    	return parents[v];
    }
    
    static void union(int v1, int v2) {
    	int p1 = find(v1);
    	int p2 = find(v2);
    	
    	if (p1 < p2) parents[p2] = p1;
    	else parents[p1] = p2;
    }
};