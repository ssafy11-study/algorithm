import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1931_3조_이현수 {
    static Meeting[] meetings;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        meetings = new Meeting[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            meetings[i] = new Meeting(startTime, endTime);
        }

        Arrays.sort(meetings);
        answer++;
        Meeting current = meetings[0];
        for(int i = 1; i < meetings.length; i++){
            if(meetings[i].startTime >= current.endTime) {
                answer++;
                current = meetings[i];
            }
        }
        System.out.print(answer);
    }

    static class Meeting implements Comparable<Meeting> {
        int startTime, endTime;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Meeting o) {
            if(this.endTime == o.endTime) return this.startTime - o.startTime;
            return this.endTime - o.endTime;
        }
    }
}
