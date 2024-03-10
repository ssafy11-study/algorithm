import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Node[] tree;    // 0 : A
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        tree = new Node[N];

        // 배열 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = st.nextToken().toCharArray()[0] - 'A';
            int l = st.nextToken().toCharArray()[0] - 'A';
            int r = st.nextToken().toCharArray()[0] - 'A';

            Node temp = new Node(l, r);
            tree[p] = temp;
        }

        pre(0);
        sb.append('\n');
        in(0);
        sb.append('\n');
        post(0);
        System.out.println(sb);
    }

    static void pre(int idx) {
        sb.append((char)(idx+'A'));
        int left = tree[idx].left;
        int right = tree[idx].right;
        if(left >= 0) pre(left);
        if(right >= 0) pre(right);
    }

    static void in(int idx) {
        int left = tree[idx].left;
        int right = tree[idx].right; 
        if(left >= 0) in(left);
        sb.append((char)(idx+'A'));
        if(right >= 0) in(right);
    }

    static void post(int idx) {
        int left = tree[idx].left;
        int right = tree[idx].right; 
        if(left >= 0) post(left);
        if(right >= 0) post(right);
        sb.append((char)(idx+'A'));
    }
}

class Node {
    int left;
    int right;

    Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}