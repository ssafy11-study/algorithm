import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    
    static String str, bomb;
    static char[] seq;
    static int idx = -1;
    
    public static void main(String[] args) throws IOException {
    	str = br.readLine();
    	bomb = br.readLine();
    	seq = new char[str.length()];
    	
    	for (int i = 0; i < str.length(); i++) {
    		seq[++idx] = str.charAt(i);		
    		int tIdx = 0;
    		if (idx < bomb.length() - 1) continue;
    		while (tIdx < bomb.length() && seq[idx - tIdx] == bomb.charAt(bomb.length() - 1 - tIdx)) tIdx++;
    		if (tIdx == bomb.length()) idx -= bomb.length();
    	}
    	
    	if (idx == -1) sb.append("FRULA");
    	else for (int i = 0; i <= idx; i++) sb.append(seq[i]);
    	System.out.println(sb);
    }
};