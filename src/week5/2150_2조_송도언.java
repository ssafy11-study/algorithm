import java.io.*;
import java.util.*;
public class Main {
    static ArrayList<Integer>[] graph, reverseGraph;
    static List<Queue<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static Deque<Integer> stack = new ArrayDeque<>();
    static int N, M;

    static void search(int start){
        visited[start] = true;
        for(int next : graph[start]){
            if(visited[next]) continue;
            search(next);
        }
        stack.push(start);
    }

    static void reSearch(int start, int groupNum){
        visited[start] = true;
        list.get(groupNum).add(start);

        for(int next : reverseGraph[start]){
            if(!visited[next]){
                reSearch(next, groupNum);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        reverseGraph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph[n1].add(n2);
            reverseGraph[n2].add(n1);
        }

        for (int i = 1; i <= N; i++) {
            if(!visited[i]) search(i);
        }

        Arrays.fill(visited, false);

        // 역방향 탐색
        int groupNum = 0;
        while (!stack.isEmpty()){
            int start = stack.pop();

            // SCC에 포함되어있다는 뜻
            if(visited[start]) continue;
            list.add(new PriorityQueue<>());
            reSearch(start, groupNum++);
        }
        sb.append(groupNum).append('\n');
        Collections.sort(list, (Comparator.comparingInt(Queue::peek)));
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Queue<Integer> q = list.get(i);
            while (!q.isEmpty()){
                sb.append(list.get(i).poll()).append(' ');
            }
            sb.append("-1").append('\n');
        }
        System.out.println(sb);
    }
}
