package study;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _15323_3조_이현수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<String> word = new PriorityQueue<>(); // 단어정렬
        HashMap<Character, Queue<String>> wordList = new HashMap<>();
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        String str;

        for(int i = 0; i < 26; i++){
            wordList.put((char)(97+i), new LinkedList<>());
        }

        for(int i = 0; i < K; i++){
            str = br.readLine();
            word.offer(str);
        }
        for(int i = 0; i < K; i++){
            str = word.poll(); // 우선순위 큐는 poll 시 정렬된 요소들 획득 가능
            wordList.get(str.charAt(0)).offer(str);
        }

        for(int i = 0; i < N; i++){
            char letter = br.readLine().charAt(0);
            String answer = wordList.get(letter).poll();
            wordList.get(letter).offer(answer);
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
