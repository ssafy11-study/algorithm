// Subject: Study of Algorithm with SSAFY
// ProblemNo: 2606
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {

    static final int MX = 100000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, x, y, res;
    static boolean vtd[];
    static Queue<Integer> q = new LinkedList<>();
    static ArrayList<Integer>[] gph;
    
    public static void main(String[] args) throws Exception{
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        gph = new ArrayList[N];
        for (int i = 0; i < N; i++) gph[i] = new ArrayList<>();
        vtd = new boolean[N];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()); x--;
            y = Integer.parseInt(st.nextToken()); y--;
            gph[x].add(y);
            gph[y].add(x);
        }
        vtd[0] = true;
        q.add(0);

        while(!q.isEmpty()){
            int now = q.remove();
            for(int tar : gph[now]){
                if(vtd[tar]) continue;
                vtd[tar] = true;
                res++;
                q.add(tar);
            }
        }
        System.out.println(res);
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