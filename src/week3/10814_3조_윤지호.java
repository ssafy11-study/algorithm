import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        List<pair> lst = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String n = st.nextToken();
            lst.add(new pair(a, n));
        }
        lst.sort(((o1, o2) -> o1.age - o2.age));
        StringBuilder sb = new StringBuilder();
        for(pair p : lst) {
            sb.append(p).append("\n");
        }
        System.out.println(sb);
    }
}

class pair {
    int age;
    String name;
    pair(int a, String n) {
        this.age = a;
        this.name = n;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(age).append(" ").append(name).toString();
    }
}