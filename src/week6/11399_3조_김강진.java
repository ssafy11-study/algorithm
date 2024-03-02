
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, ans,lines[];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        lines = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            lines[i] = Integer.parseInt(st.nextToken());
        }
        // 정렬
        Arrays.sort(lines);

        int ans = lines[0];

        for (int i=1;i<N;i++){
            lines[i] = lines[i-1]+ lines[i];
            ans += lines[i];
        }

        System.out.println(ans);
    }

}
