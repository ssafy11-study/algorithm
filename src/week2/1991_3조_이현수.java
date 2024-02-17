package submit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node{
    Node lt, rt;
    char data;

    Node(char data, Node lt, Node rt){ // node
        this.data = data;
        this.lt = lt;
        this.rt = rt;
    }
    Node(char data){ // leaf
        this.data = data;
        this.lt = null;
        this.rt = null;
    }

    Node allocate(Node lChild, Node rChild){
        if(lChild.data != '.') this.lt = lChild;
        if(rChild.data != '.') this.rt = rChild;
        return this;
    }
}

public class S1991 {
    static ArrayList<Node> nodeArr = new ArrayList<>();

    static Node findRoot(char data){ // 부모노드 반환
        for(Node root : nodeArr)
            if(root.data == data) return root;
        return null;
    }

    static void addNode(Node node){ // node Arr에 추가
        if(!nodeArr.contains(node)) nodeArr.add(node);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // root Node 초기화
        Node root = new Node(st.nextToken().charAt(0)); // root는 항상 A
        // 자식 Node 초기화
        Node lt = new Node(st.nextToken().charAt(0));
        Node rt = new Node(st.nextToken().charAt(0));

        // root Node에 자식 Node 할당
        root.allocate(lt, rt);

        // 리스트에 노드 추가
        addNode(root);
        addNode(lt);
        addNode(rt);

        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            Node pt = findRoot(st.nextToken().charAt(0));
            lt = new Node(st.nextToken().charAt(0));
            rt = new Node(st.nextToken().charAt(0));
            pt.allocate(lt, rt);

            addNode(lt);
            addNode(rt);
        }

        preTraversal(root); // 전위
        System.out.println();
        inTraversal(root); // 중위
        System.out.println();
        postTraversal(root); // 후위
    }

    static void preTraversal(Node node){
        if(node == null) return;
        System.out.print(node.data);
        preTraversal(node.lt);
        preTraversal(node.rt);
    }
    static void inTraversal(Node node){
        if(node == null) return;
        inTraversal(node.lt);
        System.out.print(node.data);
        inTraversal(node.rt);
    }
    static void postTraversal(Node node){
        if(node == null) return;
        postTraversal(node.lt);
        postTraversal(node.rt);
        System.out.print(node.data);
    }
}
