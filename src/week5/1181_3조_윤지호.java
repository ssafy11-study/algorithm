import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static List<String> input;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String inputStr = br.readLine();
            if(!input.contains(inputStr)) {
                input.add(inputStr);
            }
        }

        Collections.sort(input, (o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2):o1.length() - o2.length());

        for(String s : input) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
