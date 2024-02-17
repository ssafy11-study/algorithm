// Subject: Study of Algorithm with SSAFY
// ProblemNo: 1918
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static int priority(char c){
        String tar = "()+-*/";
        return tar.indexOf(c) / 2;
    }
    //Reference: https://woongsios.tistory.com/288
    static String solve(String s){
        String ret = "";
        Deque<Character> operand = new ArrayDeque<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= 'A' && c <= 'Z') ret += c;
            else if(priority(c) > 0){
                while(!operand.isEmpty() && (priority(operand.peek()) >= priority(c))) ret += operand.pop();
                operand.push(c);
            }
            else if(c == '(') operand.push(c);
            else{
                while(operand.peek() != '(') ret += operand.pop();
                operand.pop();
            }
        }
        while(!operand.isEmpty()) ret += operand.pop();
        return ret;
    }

	static final int MX = 10001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, w[];
    static String target;
    
    public static void main(String[] args) throws Exception{
        target = br.readLine();
        System.out.println(solve(target));
    }
}
