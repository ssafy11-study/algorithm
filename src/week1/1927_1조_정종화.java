// Subject: Study of Algorithm with SSAFY
// ProblemNo: 1927
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {

    static final int MX = 100000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, x;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++){
            x = Integer.parseInt(br.readLine());
            if(x != 0) pq.add(x);
            else{
                if(!pq.isEmpty()) System.out.println((int)pq.poll());
                else System.out.println(0);
            }
        }
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
    }

}