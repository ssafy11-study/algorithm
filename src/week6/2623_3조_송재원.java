import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        OrderManager manager = new OrderManager(N);

        while (M-->0) {
            st = new StringTokenizer(reader.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int start = Integer.parseInt(st.nextToken());
            manager.addFirstSinger(start);

            int from = start;
            while (i-->0) {
                int to = Integer.parseInt(st.nextToken());
                manager.addSinger(from, to);
                from = to;
            }
        }

        System.out.print(manager.compute());
    }

    static class OrderManager {
        int N;
        Singer[] singers;
        BitSet visited;
        Queue<Singer> que = new ArrayDeque<>();

        public OrderManager(int n) {
            N = n;
            singers = new Singer[n+1];
            visited = new BitSet(n+1);
        }

        public void addFirstSinger(int id) {
            if (singers[id] == null) {
                singers[id] = new Singer(id);
                que.add(singers[id]);
            }
        }
        public void addSinger(int from, int to) {
            if (singers[to] == null) {
                singers[to] = new Singer(to);
            }
            singers[from].addNext(singers[to]);
        }

        public String compute() {
            StringBuilder sb = new StringBuilder();

            int count = 0;
            for (int i = 1; i <= N; ++i) {
                if (singers[i] == null) {
                    sb.append(i).append('\n');
                    count++;
                }
            }

            while (!que.isEmpty()) {
                Singer singer = que.poll();
                if (singer.in == 0 && !visited.get(singer.id)) {
                    visited.set(singer.id);
                    count++;
                    sb.append(singer.id).append('\n');
                    singer.next.stream()
                            .filter(s -> !visited.get(s.id))
                            .peek(s -> s.in--)
                            .filter(s -> s.in == 0)
                            .forEach(que::add);
                }
            }

            if (count != N) return "0\n";
            else return sb.toString();
        }
    }

    static class Singer {
        int in, id;
        List<Singer> next;

        public Singer(int id) {
            in = 0;
            this.id = id;
            next = new LinkedList<>();
        }

        public void addNext(Singer s) {
            s.in++;
            next.add(s);
        }
    }
}
