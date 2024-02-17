package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class _10845_3조_이현수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> myQueue = new LinkedList<>();
        int myNum = Integer.parseInt(br.readLine());
        String command;
        int a;
        int end = 0;
        StringTokenizer st;

        for(int i = 0; i < myNum; i++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            switch (command) {
                case "push" -> {
                    int manyWord;
                    manyWord = Integer.parseInt(st.nextToken());
                    myQueue.offer(manyWord);
                    end = manyWord;
                }
                case "pop" -> {
                    if (myQueue.isEmpty()) {
                        System.out.println(-1);
                    } else System.out.println(myQueue.poll());
                }
                case "empty" -> {
                    if (myQueue.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                }
                case "size" -> {
                    System.out.println(myQueue.size());
                }
                case "front" -> { // 맨 앞에있는 것

                    if (!myQueue.isEmpty()) {
                        a = myQueue.peek();
                        System.out.println(a);
                    } else System.out.println(-1);
                }
                case "back" -> { // 처음에 있는 숫자
                    if (!myQueue.isEmpty()) System.out.println(end);
                    else System.out.println(-1);
                }
            }
        }
    }
}
