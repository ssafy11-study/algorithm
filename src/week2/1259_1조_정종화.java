// Subject: Study of Algorithm with SSAFY
// ProblemNo: 1259
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
	
	static final int MX = 12;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static boolean check(String s){
        int len = s.length();
        for(int i = 0; i <= len - 1 - i; i++){
            if(s.charAt(i) != s.charAt(len - 1 - i)) return false;
        }    
        return true;
    }

    public static void main(String[] args) throws Exception{
        while(true){
            String s = br.readLine();
            if(s.equals("0")) break;
            System.out.print(check(s)? "yes\n":"no\n");
        }
    }
}
