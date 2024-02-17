// Subject: Study of Algorithm with SSAFY
// ProblemNo: 2164
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
    static int N;
    
    static int solution(int start, int gap, int checker, int left){
        if(left == 1) return start + 1;
        if(checker == 0) start += gap;
        gap *= 2;
        int next_left = (checker + left) / 2;
        checker ^= (left % 2);
        return solution(start, gap, checker, next_left);
    }

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        System.out.print(solution(0, 1, 0, N));
    }
}
