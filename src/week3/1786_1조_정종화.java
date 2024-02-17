// Subject: Study of Algorithm with SSAFY
// ProblemNo: 1786
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

	static final int MX = 10001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static String s1, s2;
    static int fail[];
    static Deque<Integer> queue = new ArrayDeque<>();
    
    public static void main(String[] args) throws Exception{
        s1 = br.readLine();
        s2 = br.readLine();
        fail = new int[s2.length()];
        
        int i, j;
        for(i = 1, j = 0; i < s2.length(); i++){
            while(j > 0 && (s2.charAt(i) != s2.charAt(j))) j = fail[j - 1];
            if(s2.charAt(i) == s2.charAt(j)) fail[i] = ++j;
        }
        for(i = 0, j = 0; i < s1.length(); i++){
            while(j > 0 && (s1.charAt(i) != s2.charAt(j))) j = fail[j - 1];
            if(s1.charAt(i) == s2.charAt(j)){
                ++j;
                if(j == s2.length()){
                    queue.offer(i - j + 1 + 1);
                    j = fail[j - 1];
                }
            }
        }
        sb.append(queue.size()).append('\n');
        while(!queue.isEmpty()) sb.append(queue.poll()).append(' ');
        System.out.print(sb);
    }
}