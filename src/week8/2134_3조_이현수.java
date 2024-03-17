import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static long x, y;
    static int[] old, current;
    static int productNum = 0, currentCapacity = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        old = new int[n+1];
        current = new int[m+1];
        for(int i = 1; i <= n; i++){
            old[i] = Integer.parseInt(br.readLine());
            productNum += old[i];
        }
        for(int i = 1; i <= m; i++){
            current[i] = Integer.parseInt(br.readLine());
            currentCapacity += current[i];
        }

        if(currentCapacity >= productNum) x = productNum;
        else x = currentCapacity;

        int cnt = 1;
        for(int i = 1; i <= x; i++){
            if(old[cnt] == 0) {
                i--;
                cnt++;
                continue;
            }
            old[cnt]--;
            y += cnt;
        }

        int increase = 0; cnt = 1;
        for(int i = 1; i <= x; i++){
            if(increase == current[cnt]) {
                increase = 0;
                cnt++;

                i--;
                continue;
            }
            increase++;
            y += cnt;
        }
        System.out.print(x + " " + y);
    }
}
