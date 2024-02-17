package s1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**선수 지식
 *  지수법칙: a ^ (n+m) = a^n * a^m
 *  모듈러 성질: (a*b) % c = (a % c * b % c) % c
 *  */

// 이현수
public class Multiplication {
    static long C;
    public static void main(String[] args) throws IOException {
        Multiplication m = new Multiplication();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer;
        long base = Long.parseLong(st.nextToken()); // 밑
        long expo = Long.parseLong(st.nextToken()); // 지수

        C = Long.parseLong(st.nextToken());

        answer = m.recur(base, expo);
        System.out.print(answer);

    }

    public long recur(long base, long expo){
        if(expo == 1) return base % C;

        // 지수법칙 적용(지수를 반으로 분할하여 문제를 해결, 2의 4승 = 2^2 * 2^2)
        long division = recur(base, expo / 2); // 지수의 절반으로 분할

        // 모듈러 성질이 적용된다
        if(expo % 2 == 1) return (division * division % C) * base % C; // 지수가 홀수인 경우
        else return (division * division) % C; // 짝수인 경우
    }
}
/**선수 지식
 *  지수법칙: a ^ (n+m) = a^n * a^m
 *  모듈러 성질: (a*b) % c = (a % c * b % c) % c
 *  */