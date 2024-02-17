package submit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        Queue<Integer> deck = new LinkedList<>();
        int oNum;

        for (int i = 1; i <= size; i++) deck.offer(i);
        while(deck.size() > 1){
            deck.poll();
            oNum = deck.peek();
            deck.poll();
            deck.offer(oNum);
        }
        System.out.print(deck.peek());
    }
}