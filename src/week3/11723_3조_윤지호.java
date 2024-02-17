import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> S = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            int num = 0;
            if(st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
            }

            doFunc(input, num);
        }
        System.out.println(sb);
    }

    static void doFunc(String cmd, int parma) {
        switch(cmd) {
            case "add": doAdd(parma); break;
            case "remove": doRemove(parma); break;
            case "check": doCheck(parma);break;
            case "toggle": doToggle(parma);break;
            case "all": doAll();break;
            case "empty": doEmpty(); break;
        }
    }

    static void doAdd(int num) {
        S.add(num);
    }

    static void doRemove(int num) {
        if(S.indexOf(num) != -1)
            S.remove(S.indexOf(num));
    }

    static void doCheck(int num) {
        sb.append((S.indexOf(num) == -1) ? 0:1).append("\n");
    }

    static void doToggle(int num) {
        if(S.indexOf(num) == -1) {
            S.add(num);
        }else {
            S.remove(S.indexOf(num));
        }
    }

    static void doAll() {
        S.clear();
        S.add(1);
        for(int i=2; i<=20; i+=2) {
            S.add(i);
        }
    }

    static void doEmpty() {
        S.clear();
    }
}