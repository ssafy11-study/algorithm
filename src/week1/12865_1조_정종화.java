// Subject: Study of Algorithm with SSAFY
// ProblemNo: 12865
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {

    static final int MX = 100001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K, W, V, dp[][];
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][K + 1];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            for(int j = 0; j <= K; j++){
                if(j + W <= K) dp[i + 1][j + W] = Math.max(dp[i + 1][j + W], dp[i][j] + V);
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
            }
        }
        int res = 0;
        for(int j = 0; j <= K; j++) res = Math.max(res, dp[N][j]);
        System.out.println(res);
    }

    //Reference Note
    public void myReferences() throws Exception{
        //[sysio] always throws Exception!!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer.parseInt(st.nextToken());
        System.out.println("");
        
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
        
        //[string]
        //charAt(idx)
        
        //[Queue] add/offer remove/poll element/pick clear
        Queue<Integer> queue = new LinkedList<>();
        
    }

}