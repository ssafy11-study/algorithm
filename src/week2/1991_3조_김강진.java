// Subject: Study of Algorithm with SSAFY
// ProblemNo: 1991
// Language: JAVA
// Author: KimKangjin

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
    static StringBuilder sb = new StringBuilder();
    static char tmp;
    public static void preorder(int curIdx){
        if (curIdx <0){
            return;
        }else {
            tmp = (char) ('A'+curIdx);
            sb.append(tmp);
            preorder(tree[curIdx][0]);
            preorder(tree[curIdx][1]);
        }
    }
    public static void inorder(int curIdx){
        if (curIdx <0){
            return;
        }else {
            inorder(tree[curIdx][0]);
            tmp = (char) ('A'+curIdx);
            sb.append(tmp);
            inorder(tree[curIdx][1]);
        }
    }

    public static void postorder(int curIdx){
        if (curIdx <0){
            return;
        }else {
            postorder(tree[curIdx][0]);
            postorder(tree[curIdx][1]);
            tmp = (char) ('A'+curIdx);
            sb.append(tmp);
        }
    }
    static int[][] tree;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        tree = new int[26][2];
        for (int n=0;n<N;n++){
            st = new StringTokenizer(br.readLine());
            int parent = st.nextToken().charAt(0) - 'A';
            tree[parent][0] = st.nextToken().charAt(0) - 'A';
            tree[parent][1] = st.nextToken().charAt(0) - 'A';
        }

        preorder(0);
        System.out.println(sb);
        sb = new StringBuilder();
        inorder(0);
        System.out.println(sb);
        sb = new StringBuilder();
        postorder(0);
        System.out.println(sb);

    }
}
