// Subject: Study of Algorithm with SSAFY
// ProblemNo: B1208
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static class Info{
        int val, cnt;
        Info(int ...a){
            this.val = a[0];
            this.cnt = a[1];
        }
    }

    static void backTracking(int l, int r, int total, int idx, boolean FLAG){
        if(l == r){
            if(FLAG) set[idx].add(total);
            return;
        }
        backTracking(l + 1, r, total, idx, FLAG);
        backTracking(l + 1, r, total + v[l], idx, true);
        
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, S, ptr, l, r, v[];
    static long res;
    static ArrayList<Integer> set[] = new ArrayList[2];
    static ArrayList<Info> left = new ArrayList();
    static ArrayList<Info> right = new ArrayList();
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        v = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) v[i] = Integer.parseInt(st.nextToken());
        
        if(N == 1){
            System.out.print((v[0] == S)? '1' : '0');
            return;
        }
        
        set[0] = new ArrayList();
        set[1] = new ArrayList();
        backTracking(0, N / 2, 0, 0, false);
        backTracking(N / 2, N, 0, 1, false);
        Collections.sort(set[0]); Collections.sort(set[1]);
        
        left.add(new Info(set[0].get(0), 1)); ptr = 0;
        for(int i = 1; i < set[0].size(); i++) {
            if(left.get(ptr).val == set[0].get(i)) left.get(ptr).cnt++;
            else { left.add(new Info(set[0].get(i), 1)); ptr++; }
        }
        
        right.add(new Info(set[1].get(0), 1)); ptr = 0;
        for(int i = 1; i < set[1].size(); i++){
            if(right.get(ptr).val == set[1].get(i)) right.get(ptr).cnt++;
            else { right.add(new Info(set[1].get(i), 1)); ptr++; }
        }
        
        l = 0; r = right.size() - 1;
        while(l < left.size() && r >= 0){
            int ans = left.get(l).val + right.get(r).val;
            if(ans < S) l++;
            else if (ans > S) r--;
            else { res += (long)left.get(l).cnt * right.get(r).cnt; l++; r--; }
        }
        
        for(Info x : left) if(x.val == S) res += (long)x.cnt;
        for(Info x : right) if(x.val == S) res += (long)x.cnt;
        System.out.print(res);
    }
}