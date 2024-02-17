package submit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1074 {
    static int answer = 0;
    static int N, r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()); // 세로
        c = Integer.parseInt(st.nextToken()); // 가로

        int length = (int)Math.pow(2, N);

        solution(r, c, length);
        System.out.println(answer);
    }

    static void solution(int r, int c, int length){
        if(length == 1) return;

        int size = length / 2;
        int point = size * size;

        if(size > r && size > c) { // 1 사분면 = 점수 없음
            solution(r, c, size);
        }
        else if(size > r && size <= c) { // 2 사분면 = 1 사분면의 점수 획득
            answer += point;
            solution(r, c - size, size);
        }
        else if(size <= r && size > c) { // 3 사분면 = 1,2 사분면의 점수 획득
            answer += 2 * point;
            solution(r - size, c, size);
        }
        else { // 4 사분면 = 1,2,3 사분면의 점수 획득
            answer += 3 * point;
            solution(r - size, c - size, size);
        }
    }
}

