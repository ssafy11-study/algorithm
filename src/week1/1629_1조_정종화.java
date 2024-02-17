// Subject: Study of Algorithm with SSAFY
// ProblemNo: 1629
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {

    static final int MX = 100000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int A, B, C;
    
    //implementation of (x ^ n) % m;
    static long exp(long x, long n, long m){
        long ret = 1;
        while(n != 0){
            if(n % 2 != 0) ret = (ret * x) % m;
            n /= 2;
            x = (x * x) % m;
        }
        return ret;
    }
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        System.out.println(exp(A, B, C));
    }

    //Reference Note
    public void myReferences() throws Exception{
        //[Map]
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        //put(<T>)  get(<T>[0])  containsKey(<T>[0])  remove(<T>[0])  size()
        
        //[Priority Queue]
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //lower first
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder()); //higher first
        PriorityQueue<int[]> pq3 = new PriorityQueue<>((o1, o2)-> o1[0] - o2[0]); //lambda
        //add(<T>)  poll(<T>)=><T>:null  remove(<T>)=>void:exception  peak(<T>)=><T>:null (no remove)  element(<T>)=><T>:exception  clear()
        // @Override
        // public int compareTo(Gillog gillog) {
        //     if (this.writeRowNumber > gillog.getWriteRowNumber()) return 1;
        //     else if (this.writeRowNumber < gillog.getWriteRowNumber()) return -1;
        //     return 0; }

        //[ArrayList]
        ArrayList<Integer>[] list = new ArrayList[10];
        for (int i = 0; i < 10; i++) list[i] = new ArrayList<>();
		//add(<T>), get(idx)=><T>
		
        //[Mathematic Symbols]
        int M = Math.max(1, 2);
        
        //[sysio] always throws Exception!!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer.parseInt(st.nextToken());
        System.out.println("");
        
        //[string]
        //charAt(idx)
        
        //[Queue] add/offer remove/poll element/pick clear
        Queue<Integer> queue = new LinkedList<>();
        
    }

}