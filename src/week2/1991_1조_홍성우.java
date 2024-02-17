package 알고리즘_스터디._2주차.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    char data;
    Node left;
    Node right;
    public Node(char item){
        data = item;
        left = null;
        right = null;
    }
}

class BinaryTree{
    Node root;

    void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data);
        preorder(node.left);
        preorder(node.right);

    }

    void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);

    }

    void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data);


    }
}
public class _1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        BinaryTree tree = new BinaryTree();

        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node((char) ('A' + i));
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            char data = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            //연결
            if (left != '.') {
                nodes[data - 'A'].left = nodes[left - 'A'];
            }
            if (right != '.') {
                nodes[data - 'A'].right = nodes[right - 'A'];
            }
        }

        //root
        tree.root = nodes[0];

        tree.preorder(tree.root);
        System.out.println();

        tree.inorder(tree.root);
        System.out.println();

        tree.postorder(tree.root);
        System.out.println();

    }
}


