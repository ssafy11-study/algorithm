import java.util.*;
import java.io.*;

class Main{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            String[] arg = br.readLine().split(" ");
            int N = Integer.parseInt(arg[0]);
            int M = Integer.parseInt(arg[1]);
            int[] start = new int[N + 1];
            int[] time = new int[N + 1];
            int[] build = new int[N + 1];
            int answer = 0;

            Queue<Integer> queue = new LinkedList<>();
            List<List<Integer>> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
                build[i] = time[i];
                list.add(new ArrayList<>());
            }

            list.add(new ArrayList<>());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int pre = Integer.parseInt(st.nextToken());
                int next = Integer.parseInt(st.nextToken());
                list.get(pre).add(next);
                start[next]++;
            }

            int destination = Integer.parseInt(br.readLine());

            for(int i = 1; i <= N; i++){
                if(start[i] == 0){
                    queue.add(i);
                }
            }

            while(!queue.isEmpty()){
                int pre = queue.poll();
                if(pre == destination) {
                    answer = build[pre];
                    break;
                }
                List<Integer> des = list.get(pre);
                for(int d : des){
                    build[d] = Math.max(build[d], build[pre] + time[d]);
                    if(--start[d] == 0){
                        queue.add(d);
                    }
                }
            }
            System.out.println(answer);
        }
    }
}