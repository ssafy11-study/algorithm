import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1149_3조_이현수 {
    static int N;
    static int[][] colorCost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        colorCost = new int[N][3];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            if(i == 0) {
                for(int j = 0; j < 3; j++) colorCost[i][j] = Integer.parseInt(st.nextToken());
                continue;
            }
            colorCost[i][0] = Math.min(colorCost[i - 1][1], colorCost[i - 1][2]) + Integer.parseInt(st.nextToken());
            colorCost[i][1] = Math.min(colorCost[i - 1][0], colorCost[i - 1][2]) + Integer.parseInt(st.nextToken());
            colorCost[i][2] = Math.min(colorCost[i - 1][0], colorCost[i - 1][1]) + Integer.parseInt(st.nextToken());

        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) if(min > colorCost[N-1][i]) min = colorCost[N-1][i];
        System.out.print(min);
    }
}
