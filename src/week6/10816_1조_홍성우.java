package 알고리즘_스터디._6주차.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _10816 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

       bf.readLine();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        while (st.hasMoreTokens()) {
            int temp = Integer.parseInt(st.nextToken());
            hashMap.put(temp, hashMap.getOrDefault(temp, 0) + 1);
        }


        bf.readLine();
        st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            int key = Integer.parseInt(st.nextToken());
            sb.append(hashMap.getOrDefault(key, 0)).append(' ');
        }
        System.out.println(sb);

    }
}
