package SSAFY.study.week7.t1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    0<= N <= 500,000 이동해야 하는 채널
    0<= M <= 9 고장난 숫자 버튼 수
    채널이 0일 때 - 버튼은 동작하지 않는다.
    S = 100 시작 채널
    풀이
    2 가지 경우
    1. 시작 채널에서 +,- 버튼만 클릭하여 이동하는 겨우 |S-N|
    2. 특정 채널 K로 이동한 후 +,-버튼을 이용하여 이동하는 경우 |K-N| + len(K)
    -> 완탐 풀이 가능.
    -> 내 생각 : 이분탐색(lower/upper bounds)

    이분탐색 해보자.
 */
public class Main2 {
    static int N, M, S, answer;
    static int[] arr;
    static boolean[] btns;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        S = 100;
        M = Integer.parseInt(br.readLine());
        btns = new boolean[10];
        if (M != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                btns[Integer.parseInt(st.nextToken())] = true;
            }
        }
        answer = Math.abs(N - S);
        /*
            + 10을 해야하는 이유
            N : 0 , M : 1, 고장난 버튼 : 0
            N*2 -> 0
            N*2+10 -> 10 ( 1,2,3,4,5,6,7,8,9를 커버)
            해 -> 100 -> 1 -> 0 : 2
            N이 한자리 수일 때를 고려해야 한다.
            N : 3 , M : 9, 고장난 버튼 : 0 1 2 3 4 5 6 7 9
            N*2 -> 6
            N*2+10 -> 16 (8을 커버)
            해 -> 100 -> 8 -> 0 : 9
         */
        arr = new int[N * 2 + 11];
        for (int i = 0; i <= N * 2+10; i++) {
            arr[i] = i;
        }
        int l=lower(N);
        int r = upper(N);
        while (l >= 0 && !check(l)) {
            l--;
        }
        if(l == -1) l = 987654321;
        String s = ""+l;
        answer = Math.min(answer, Math.abs(N-l)+s.length());

        while (r < N*2+11 && !check(r)) {
            r++;
        }
        if(r == N*2+11) r = 987654321;
        s = "" + r;
        answer = Math.min(answer, Math.abs(N-r)+s.length());
        System.out.println(answer);
        br.close();
    }
    static boolean check(int x) {
        String s = "" + x;
        for(int i=0; i<s.length();i++){
            if(btns[s.charAt(i)-'0']) return false;
        }
        return true;
    }
    static int lower(int x) {
     // 찾고자 하는 값 x보다 크거나 같은 수 중 가장 좌측에 있는 값을 찾는다.
        int right, left, mid;
        right = N * 2 + 11;
        left = 0;
        while (left < right) {
            mid = (right+left)/2;
            if(arr[mid] >= x) right = mid;
            else left = mid + 1;
        }
        return right;
    }
    static int upper(int x) {
        // x보다 큰 수 중에 가장 작은 수(가장 왼쪽에 위치한 수)
        int right, left, mid;
        right = N * 2 + 11;
        left = 0;
        while (left < right) {
            mid = (right+left)/2;
            if(arr[mid] > x) right = mid;
            else left = mid + 1;
        }
        return right;
    }
}
