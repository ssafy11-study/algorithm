import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int A, B, V;
    
    public static void main(String[] args) throws IOException {
    	st = new StringTokenizer(br.readLine());
    	A = Integer.parseInt(st.nextToken());
    	B = Integer.parseInt(st.nextToken());
    	V = Integer.parseInt(st.nextToken());
    	
    	double d = (double)(V - A) / (A - B);
    	System.out.println((int)Math.ceil(d + 1));
    }
};