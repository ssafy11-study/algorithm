// Subject: Study of Algorithm with SSAFY
// ProblemNo: 2206
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static int encode(char c){
        if(c == '.') return -1;
        return c - 'A';
    }
    
    static class Node{
	    int left, right;
	    Node(int left, int right){
	        this.left = left;
	        this.right = right;
	    }
	}
	
	static final int MX = 10001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
	static int N;
	static Node tree[];
	static char a, b, c;
	
	static void init() throws Exception {
	    N = Integer.parseInt(br.readLine());
	    tree = new Node[N];
	    for(int i = 0; i < N; i++){
	        st = new StringTokenizer(br.readLine());
	        a = st.nextToken().charAt(0);
	        b = st.nextToken().charAt(0);
	        c = st.nextToken().charAt(0);
	        tree[encode(a)] = new Node(encode(b), encode(c));
	    }
	}

    public static void main(String[] args) throws Exception{
        init();
        preOrder(0); System.out.println();
        inOrder(0); System.out.println();
        postOrder(0);
    }

    static void preOrder(int now){
        System.out.print((char)('A' + now));
        if(tree[now].left != -1) preOrder(tree[now].left);
        if(tree[now].right != -1) preOrder(tree[now].right);
    }
    
    static void inOrder(int now){
        if(tree[now].left != -1) inOrder(tree[now].left);
        System.out.print((char)('A' + now));
        if(tree[now].right != -1) inOrder(tree[now].right);
    }
    
    static void postOrder(int now){
        if(tree[now].left != -1) postOrder(tree[now].left);
        if(tree[now].right != -1) postOrder(tree[now].right);
        System.out.print((char)('A' + now));
    }
}
