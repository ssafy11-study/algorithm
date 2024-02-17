// Subject: Study of Algorithm with SSAFY
// ProblemNo: 11660
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {

    static final int MX = 1024;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, x1, x2, y1, y2;
    static long v[][], w[][];
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        v = new long[N + 1][N + 1];
        w = new long[N + 1][N + 1];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) v[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) w[i + 1][j + 1] = v[i][j] + w[i + 1][j] + w[i][j + 1] - w[i][j];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken()); x1--;
            y1 = Integer.parseInt(st.nextToken()); y1--;
            x2 = Integer.parseInt(st.nextToken()); x2--;
            y2 = Integer.parseInt(st.nextToken()); y2--;
            System.out.println(w[x2 + 1][y2 + 1] - w[x2 + 1][y1] - w[x1][y2 + 1] + w[x1][y1]);
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