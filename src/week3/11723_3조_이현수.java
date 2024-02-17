package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _11723_3조_이현수 {
    static ArrayList<Integer> set = new ArrayList<>(20);
    static StringBuilder sb = new StringBuilder();
    static void add(int e){
        if(!set.contains(e)) set.add(e);
    }

    static void remove(int e){
        if(set.contains(e)) set.remove(set.indexOf(e));
    }

    static void check(int e){
        if(set.contains(e)) sb.append(1).append("\n");
        else sb.append(0).append("\n");;
    }

    static void toggle(int e){
        if(set.contains(e)) set.remove(set.indexOf(e));
        else set.add(e);
    }

    static void all(){
        set.clear();
        for(int i = 0; i < 20; i++){
            add(i+1);
        }
    }

    static void empty(){
        set.clear();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;

        String oper; // 연산 종류
        int element; // 원소


        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            // all empty, element 가 없을 때 구현

            oper = st.nextToken();
            if(st.hasMoreTokens()) element = Integer.parseInt(st.nextToken());
            else element = 0;

            switch (oper) {
                case "add":
                    add(element);
                    break;

                case "remove":
                    remove(element);
                    break;

                case "check":
                    check(element);
                    break;

                case "toggle":
                    toggle(element);
                    break;

                case "all":
                    all();
                    break;

                case "empty":
                    empty();
                    break;
            }
        }
        System.out.print(sb);
    }

}

