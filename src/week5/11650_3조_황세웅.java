import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int N;
    static int[][] seq; 
    
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        
        seq = new int[N][2];
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	seq[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
        Arrays.sort(seq, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        
        StringBuilder sb = new StringBuilder();
        for (int[] res : seq) {
        	sb.append(res[0]).append(" ").append(res[1]).append("\n");
        }
        System.out.println(sb);
    }
}