import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n; //도시의 개수
    static int m; // 버스의 수
    static int[][] distanceMap;

    static int INF = 987654321;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(bf.readLine());
        distanceMap = new int[n + 1][n + 1];
        m = Integer.parseInt(bf.readLine());

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    distanceMap[i][j] = 0;
                } else {
                    distanceMap[i][j] = INF;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다.
            distanceMap[a][b] = Math.min(distanceMap[a][b], c);
        }
        solution();
    }

    private static void solution() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    // 중간 정점 k를 경유하는 경우 더 작은값 설정
                    distanceMap[i][j] = Math.min(distanceMap[i][j], distanceMap[i][k] + distanceMap[k][j]);

                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (distanceMap[i][j] >= INF) {
                    sb.append("0").append(" ");
                } else {
                    sb.append(distanceMap[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}