// Subject: Study of Algorithm with SSAFY
// ProblemNo: 1181
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<String> v = new ArrayList();
    static int N;
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String tmp = br.readLine();
            v.add(tmp);
        }
        v.sort((o1, o2) ->
            o1.length() == o2.length()? o1.compareTo(o2) : o1.length() - o2.length());
        String before = "";
        for(String word : v) {
            if(!word.equals(before)) System.out.println(word);
            before = word;
        }
    }
}