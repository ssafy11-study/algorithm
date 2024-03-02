
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Room[] rooms;
    static int N, ans;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        rooms = new Room[N];
        ans =0;

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            rooms[i] = new Room(s,e,e-s);
        }
        // 정렬
        Arrays.sort(rooms);

        int prevEnd = 0;

        for(Room r:rooms){
            if (r.s >= prevEnd){
                ans++;
                prevEnd = r.e;
            }
        }

        System.out.println(ans);
    }

    static class Room implements Comparable<Room>{
        int s, e, len;

        public Room(int s, int e, int len) {
            this.s = s;
            this.e = e;
            this.len = len;
        }

        @Override
        public String toString() {
            return "Room{" +
                    "s=" + s +
                    ", e=" + e +
                    ", len=" + len +
                    '}';
        }

        @Override
        public int compareTo(Room o) {
            if (this.e == o.e) return this.s-o.s; // 종료시간이 같으면 시작시간 순으로 정렬
            return this.e-o.e; // 종료시간 기준으로 오름차순 정렬
        }
    }
}
