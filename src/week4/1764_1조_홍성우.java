import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class _1764 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> unheard = new HashSet<>();
        List<String> resultList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            unheard.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (unheard.contains(name)) {
                resultList.add(name);
            }
        }

        Collections.sort(resultList);
        StringBuilder sb = new StringBuilder();
        sb.append(resultList.size()).append("\n");
        for (String name : resultList) {
            sb.append(name).append("\n");
        }
        System.out.println(sb);
    }
}
