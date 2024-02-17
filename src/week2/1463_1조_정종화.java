// Subject: Study of Algorithm with SSAFY
// ProblemNo: 1463
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
	
	static final int MX = 12;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Deque<Integer> queue = new ArrayDeque<>();
    static int N, visited[];

    static int f(int idx, int now){
        if(idx == 0) return (now % 3 == 0)? now/3:now;
        if(idx == 1) return (now % 2 == 0)? now/2:now;
        return now - 1;
    }

    static int solve(){
        if(N == 1) return 0;
        visited = new int[N + 1];
        visited[N] = 1;
        queue.addLast(N);
        while(!queue.isEmpty()){
            int now = queue.removeFirst();
            for(int i = 0; i < 3; i++){
                int next = f(i, now);
                if(visited[next] == 0){
                    if(next == 1) return visited[now];
                    visited[next] = visited[now] + 1;
                    queue.addLast(next);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        System.out.println(solve());
    }
}
