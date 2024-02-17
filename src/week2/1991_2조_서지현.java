import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{

    static List<Character>[] graph = new ArrayList[100];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for(int i =0 ; i<100; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char child1 = st.nextToken().charAt(0);
            char child2 = st.nextToken().charAt(0);
            graph[root].add(child1);
            graph[root].add(child2);
        }

        preorder('A');
        System.out.println("");
        inorder('A');
        System.out.println("");
        postorder('A');
    }

    static void preorder(char node) {
        if (node == '.') {
            return;
        }
        System.out.print(node);
        preorder(graph[node].get(0));
        preorder(graph[node].get(1));
    }

    static void inorder(char node) {
        if (node == '.') {
            return;
        }
        inorder(graph[node].get(0));
        System.out.print(node);
        inorder(graph[node].get(1));
    }
    static void postorder(char node) {
        if (node == '.') {
            return;
        }
        postorder(graph[node].get(0));
        postorder(graph[node].get(1));
        System.out.print(node);
    }
}