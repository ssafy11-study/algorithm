import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
 
public class Main {
	
	public static int N;
	public static int[] A;
	public static int M;
	public static int[] B;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	A = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for(int i=0;i<N;i++) {
    		A[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(A);
    	
    	
    	st = new StringTokenizer(br.readLine());
    	M = Integer.parseInt(st.nextToken());
    	st = new StringTokenizer(br.readLine());
    	for(int i=0;i<M;i++) {
    		int answer = 0;
    		int startIdx = 0, endIdx = N - 1;
    		int target = Integer.parseInt(st.nextToken());
    		
    		while(startIdx <= endIdx) {
    			int mid = ( startIdx + endIdx) / 2;
    			if(A[mid] == target) {
    				answer = 1;
    				break;
    			}
    			if(A[mid] < target) startIdx = mid + 1;
    			else if (A[mid] > target) endIdx = mid - 1;
    		}
    		System.out.println(answer);
    	}    	
    }
}