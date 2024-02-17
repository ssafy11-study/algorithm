package solved.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MinHeap {
    // 이현수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        int dataNum = Integer.parseInt(br.readLine());
        int outCnt = 0, temp;

        for(int i = 0; i < dataNum; i++){
            temp = Integer.parseInt(br.readLine());
            if(temp == 0) outCnt++;
            if(outCnt > 0) {
                if(minHeap.isEmpty()) sb.append(0 + "\n");
                else sb.append(minHeap.poll() + "\n");
                outCnt--;
            }
            else minHeap.add(temp);
        }

        System.out.print(sb);
    }
}
