package s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
public class PoketmonMaster {
    // 이현수
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String sQ;
        String name;

        HashMap<Integer, String> idKeyMap = new HashMap<>();
        HashMap<String, Integer> nameKeyMap = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 포켓몬 수
        int m = Integer.parseInt(st.nextToken()); // q 개수

        for(int i = 0; i < n; i++){
            name = br.readLine();
            idKeyMap.put(i+1, name);
            nameKeyMap.put(name, i+1);
        }

        for(int j = 0; j < m; j++){
            sQ = br.readLine(); // 문제 입력
            // 이름으로 아이디 조회
            if(sQ.charAt(0) - '0' < 10) sb.append(idKeyMap.get(Integer.parseInt(sQ)) + "\n");
            // 아이디로 이름 조회
            else sb.append(nameKeyMap.get(sQ) + "\n");
        }
        System.out.println(sb);

    }
}
