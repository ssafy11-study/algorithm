package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _18870_3조_이현수 {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()), i;
        st = new StringTokenizer(br.readLine());

        // q에 원본 데이터 삽입, pq에 데이터 중복없이 저장
        for(i = 0; i < N; i++){
            int temp = Integer.parseInt(st.nextToken());
            q.add(temp);
            pq.add(temp); // 중복 없는 데이터 저장 필요 contains 사용 금지
        }

        i = 0;
        // pq에서 poll 되는 순서에 따라 map에 <data, index> 저장
        while(!pq.isEmpty()) if (map.putIfAbsent(pq.poll(), i) == null) i++; // putIfAbsent가 성공한 경우에만 i를 증가시킴 (성공 시 null 반환, 실패 시 map.get(key) 반환)

        // 값에 따른 index(압축 좌표) 출력
        while(!q.isEmpty()) sb.append(map.get(q.poll())).append(" ");
        System.out.print(sb);
    }
}
