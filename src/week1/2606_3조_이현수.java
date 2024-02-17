package s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Virus {
    // 이현수
    static int[][] network;
    static int[] infection;
    static int answer = 0, vertex;
    public void BFS(int com){

        // 무방향 그래프
        // 1,3 2,3 3,4

        // 한계: 입력의 수에 따른 메모리 한계 Exception in thread "main" java.lang.OutOfMemoryError: Java heap space, 백준의 메모리
        // 데이터가 100,000개 라고 쳤을 경우, 메모리 생성은 100,000 ^ 2 * 4(byte)

        // 인접리스트의 삽입, 삭제 문제 해결 -> ArrayList [] 활용
        // 연결 -> 엣지 2 * E(간선의 개수) 6입력 시 12번의 호출만 일어남, 간선의 개수를 잘 보자!
        Queue<Integer> q = new LinkedList<>();
        q.offer(com);
        infection[com]++;
        while(!q.isEmpty()){
            int current = q.poll();
            for(int i = com+1; i <= vertex; i++){
                if((network[i][current] == 1 || network[current][i] == 1) && infection[i] == 0) {
                    answer++;
                    infection[i]++;
                    q.offer(i);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Virus v = new Virus();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        vertex = Integer.parseInt(br.readLine());
        int v1, v2;

        infection = new int[vertex+1]; // 방문 컴퓨터 체크 배열
        network = new int[vertex+1][vertex+1]; // 네트워크

        int pairNum = Integer.parseInt(br.readLine()); // 순서쌍 개수
        for(int i = 0; i < pairNum; i++){
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            network[v1][v2] = 1;
        }
        v.BFS(1);
        System.out.print(answer);

    }
}
