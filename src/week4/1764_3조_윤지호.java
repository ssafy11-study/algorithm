import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<String, Integer> map = new HashMap<>();
    static int N, M;
    static List<String> result = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            map.put(name, 0);
        }

        for(int i=0; i<M; i++) {
            String name = br.readLine();
            if(map.containsKey(name)) {
                result.add(name);
            }
        }

        Collections.sort(result);
        for(String s:result) {
            sb.append(s).append("\n");
        }
        System.out.println(result.size());
        System.out.println(sb);
    }
}
