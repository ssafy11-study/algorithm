import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int N, M;
    static int[] seq; 
    
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        seq = new int[N];
        for (int i = 0; i < N; i++) {
        	seq[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(seq);
        
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
        	if (binarySearch(Integer.parseInt(st.nextToken()))) sb.append(1);
        	else sb.append(0);
        	sb.append("\n");
        }
        System.out.println(sb);
    }
    
    static boolean binarySearch(int target) {
    	int left = -1; // false
    	int right = N - 1; // true
    	int mid;
    	
    	while (left + 1 < right) {
    		mid = (left + right) / 2;
    		if (seq[mid] >= target) right = mid;
    		else left = mid;
    	}
    	
    	return seq[right] == target;
    }
}