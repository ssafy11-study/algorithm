import java.io.*;
import java.util.*;

public class Main {
    static Queue<Integer> queue = new LinkedList<>();
    static int depth = 0;
    static int[] arr = new int[1_000_001];
    static int N, K;
    static int bfs(int x, int y, int n) {
        depth = 0;

        queue.add(x);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int temp = queue.poll();
                if(temp == y) {
                    return depth;
                }
                if(temp * 2 <= 100_000 && arr[temp * 2]++ == 0)queue.add(temp * 2);
                if(arr[temp + n]++ == 0)queue.add(temp + n);
                if(temp - n >= 0 && arr[temp - n]++ == 0)queue.add(temp - n);
            }
            depth++;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs(N, K, 1);
        System.out.println(depth);
    }
}
