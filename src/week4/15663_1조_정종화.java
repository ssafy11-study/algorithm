// Subject: Study of Algorithm with SSAFY
// ProblemNo: B15663
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    
    static boolean next_permutation() {
        for (int a = p.length - 2; a >= 0; --a){
            if (p[a] < p[a + 1]) {
                for (int b = p.length - 1;; --b) {
                    if (p[b] > p[a]) {
                        int t = p[a];
                        p[a] = p[b];
                        p[b] = t;
                        for (++a, b = p.length - 1; a < b; ++a, --b) {
                            t = p[a];
                            p[a] = p[b];
                            p[b] = t;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, sz, p[];
    static ArrayList<ArrayList<Integer>> res = new ArrayList();
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        p = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) p[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(p);
        while(true){
            ArrayList<Integer> arr = new ArrayList();
            for(int i = 0; i < M; i++) arr.add(p[i]);
            if(res.size() == 0) { res.add(arr); sz++; }
            else{
                boolean SAME = true;
                for(int i = 0; SAME && i < M; i++) SAME &= res.get(sz - 1).get(i) == arr.get(i);
                if(!SAME) { res.add(arr); sz++; }
            }
            if(!next_permutation()) break;
        }
        for(ArrayList<Integer> now : res){
            for(Integer x : now) sb.append(x).append(' ');
            sb.append('\n');
        }
        System.out.print(sb);
    }
}