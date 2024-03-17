import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[] mbti;
    static int N, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            mbti = new String[N];
            answer = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) mbti[i] = st.nextToken();
            if(N > 32) sb.append(0).append("\n");
            else {
                comb(0, 0, new int[3]);
                sb.append(answer).append("\n");
            }
        }
        System.out.print(sb);
    }

    static void comb(int L, int startIdx, int[] com){
        if(L == 3){
            String[] peopleMbti = new String[3];
            for(int i = 0; i < 3; i++) peopleMbti[i] = mbti[com[i]];
            int temp = calDistance(peopleMbti);
            if(answer > temp) answer = temp;

            return;
        }

        if(startIdx >= N) return;
        for(int i = startIdx; i < N; i++){
            com[L] = i;
            comb(L+1, i+1, com);
        }
    }

    static int calDistance(String[] mbtiList){
        int p1p2 = 0;
        int p1p3 = 0;
        int p2p3 = 0;
        for(int i = 0; i < 4; i++) {
            if(mbtiList[0].charAt(i) != mbtiList[1].charAt(i)) p1p2++;
            if(mbtiList[0].charAt(i) != mbtiList[2].charAt(i)) p1p3++;
            if(mbtiList[1].charAt(i) != mbtiList[2].charAt(i)) p2p3++;
        }
        return p1p2 + p1p3 + p2p3;
    }
}
