// Subject: Study of Algorithm with SSAFY
// ProblemNo: 11053
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {

    static final int MX = 100001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, x, idx;
    static ArrayList<Integer> v = new ArrayList<>();

    static int custom_lower_bound(int tar){
        int lo = 0, hi = v.size() - 1;
        int ret = v.size();
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(tar <= v.get(mid)){
                ret = mid;
                hi = mid - 1;
            }
            else lo = mid + 1;
        }
        return ret;
    }

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            x = Integer.parseInt(st.nextToken());
            idx = custom_lower_bound(x);
            if(idx == v.size()) v.add(x);
            else v.set(idx, x);
        }
        System.out.println(v.size());
    }
}