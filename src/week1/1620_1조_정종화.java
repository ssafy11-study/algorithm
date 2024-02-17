// Subject: Study of Algorithm with SSAFY
// ProblemNo: 11866
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {

    static final int MX = 100000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static String v[];
    static HashMap<String, Integer> map = new HashMap<String, Integer>();
    
    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        v = new String[N];
        for(int i = 0; i < N; i++){
            String tmp = br.readLine();
            map.put(tmp, i + 1);
            v[i] = tmp;
        }
        for(int i = 0; i < M; i++){
            String tmp = br.readLine();
            if(tmp.charAt(0) >= '0' && tmp.charAt(0) <= '9') System.out.println(v[Integer.parseInt(tmp) - 1]);
            else System.out.println(map.get(tmp));
        }
        
    }
    
    public void reference_sysio() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer.parseInt(st.nextToken());
        System.out.println("");
    }
    
    public void reference_string(){
        //charAt(idx)
        
    }
    
    public void reference_mathematic_symbols(){
        int M = Math.max(1, 2);
    }
    
    public void reference_map(){
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        //put(<T>), get(<T>[0]), containsKey(<T>[0]), remove(<T>[0]), size()
        
    }
}