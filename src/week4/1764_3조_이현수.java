package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class _1764_3조_이현수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> people = new HashMap<>(); 
        String name;
        for(int i = 0; i< N; i++){
            name = br.readLine();
            people.put(name, people.getOrDefault(name, 0)+1);
        }

        for(int i = 0; i< M; i++){
            name = br.readLine();
            people.put(name, people.getOrDefault(name, 0)+1);
        }

        List<String> keyList = new ArrayList<>(people.keySet());
        keyList.sort(String::compareTo);

        int cnt = 0;
        for(String str : keyList){
            if(people.get(str) == 2) {
                cnt++;
                sb.append(str).append("\n");
            }
        }
        System.out.println(cnt);    
        System.out.print(sb);

    }
}
