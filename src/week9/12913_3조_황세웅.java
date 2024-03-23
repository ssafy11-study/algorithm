import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int N, K;
    static double[][] weight;
    static double[][] dist;
    
    public static void main(String[] args) throws IOException {
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	weight = new double[N][N];
    	for (int i = 0; i < N; i++) {
    		String[] line = br.readLine().split("");
    		for (int j = 0; j < N; j++) {
    			weight[i][j] = Double.parseDouble(line[j]);
    		}
    	}
    	
    	dist = new double[N][K + 1];
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < K + 1; j++) {
    			dist[i][j] = Double.MAX_VALUE;    			
    		}
    	}
    	dist[0][0] = 0;
    	
    	PriorityQueue<Path> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o1.w, o2.w));
    	pq.offer(new Path(0, 0, 0));
    	
    	while (!pq.isEmpty()) {
    		Path curr = pq.poll();
    		for (int next = 0; next < N; next++) {
    			if (curr.k < K) {
    				double newPath = curr.w + (weight[curr.v][next] / 2);
    				if (newPath < dist[next][curr.k + 1]) {
    					dist[next][curr.k + 1] = newPath;
    					pq.offer(new Path(next, newPath, curr.k + 1));
    				}
    			}
    			double newPath = curr.w + weight[curr.v][next];
    			if (newPath < dist[next][curr.k]) {
					dist[next][curr.k] = newPath;
					pq.offer(new Path(next, newPath, curr.k));
				}
    		}
    	}
    	
    	double ans = Double.MAX_VALUE;
    	for (int i = 0; i < K + 1; i++) {
    		ans = Math.min(ans, dist[1][i]);
    	}
    	System.out.println(ans);
    }
    
    static class Path {
    	int v;
    	double w;
    	int k;
    	
    	Path(int v, double w, int k) {
    		this.v = v;
    		this.w = w;
    		this.k = k;
    	}
    }
};