import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int G, P, cnt;
    static int[] gates;
    static boolean closed;

    public static void main(String[] args) throws IOException {
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());

        gates = new int[G + 1];
        for (int i = 0; i < G + 1; i++) {
            gates[i] = i;
        }

        for (int i = 0; i < P; i++) {
            int gate = find(Integer.parseInt(br.readLine()));
            if (gate == 0) closed = true;
            if (closed) continue;
            gates[gate] = find(gate - 1);
            cnt++;
        }
        System.out.println(cnt);
    }

    static int find(int v) {
        if (gates[v] != v) gates[v] = find(gates[v]);
        return gates[v];
    }
};
