// Subject: Study of Algorithm with SSAFY
// ProblemNo: 14003
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static class State{
        int val, idx;
        State(int ...a){
            this.val = a[0];
            this.idx = a[1];
        }
        void update(int ...a){
            this.val = a[0];
            this.idx = a[1];
        }
    }

    static int customLowerBound(int key){
        int l, r, ret;
        l = 0; r = w.size() - 1; ret = w.size();
        while(l <= r){
            int mid = (l + r) / 2;
            if(w.get(mid).val < key) l = mid + 1;
            else{
                ret = mid;
                r = mid - 1;
            }
        }
        return ret;
    }

	static final int MX = 10001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<State> w = new ArrayList();
    static Deque<Integer> stack = new ArrayDeque<>();
    static int N, ptr, v[], rev[];
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        v = new int[N]; rev = new int[N];
        for(int i = 0; i < N; i++){
            v[i] = Integer.parseInt(st.nextToken());
            ptr = customLowerBound(v[i]);
            if(ptr == w.size()) w.add(new State(v[i], i));
            else w.get(ptr).update(v[i], i);
            if(ptr == 0) rev[i] = -1;
            else rev[i] = w.get(ptr - 1).idx;
        }
        sb.append(w.size()).append('\n');
        for(int i = w.get(w.size() - 1).idx; i != -1; i = rev[i]) stack.push(v[i]);
        while(!stack.isEmpty()) sb.append(stack.pop() + " ");
        System.out.print(sb);
    }
}
