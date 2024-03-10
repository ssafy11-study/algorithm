import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int len = (int) Math.pow(2, N);

        checkZ2(len, r, c);
        System.out.println(result);
    }

    static void checkZ2(int len, int row, int col) {
        len = len / 2;
        while (len > 0) {
            if (col >= len && row < len) { // 오른쪽 위
                result += (len * len);
                col = col - len;
            } else if (col < len && row >= len) { // 왼쪽 아래
                result = result + (len * len) * 2;
                row = row - len;
            } else if (col >= len && row >= len) { // 오른쪽 아래
                result = result + (len * len) * 3;
                row = row - len;
                col = col - len;
            }
            len = len >> 1;
        }
    }
}