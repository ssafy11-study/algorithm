package SSAFY.study.week8.t4276;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
    baekjoon 4276 0이 몇 개?

    원본 문제
    Problem E: How many 0's?
    A Benedict monk No. 16 writes down the decimal representations of all natural numbers between and including m and n, m ≤ n. How many 0's will he write down?
    Input consists of a sequence of lines. Each line contains two unsigned 32-bit integers m and n, m ≤ n. The last line of input has the value of m negative and this line should not be processed.

    For each line of input print one line of output with one integer number giving the number of 0's written down by the monk.

    Sample input
    10 11
    100 200
    0 500
    1234567890 2345678901
    0 4294967295
    -1 -1
    Output for sample input
    1
    22
    92
    987654304
    3825876150

 */
public class Main {
    static long N, M, cnt, ten;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Long.parseLong(st.nextToken());
            M = Long.parseLong(st.nextToken());
            if(N == -1) break;
            cnt = 0;
            ten = 1;
            if(N == 0) { // 크기(길이)가 1인 숫자가 0을 가질 수 있는 경우는 0뿐이다.
                N+=10;
                cnt++;
            }
            while (N <= M) { // ==을 포함해야 하는 이유 :  N = 1000, M = 1000이라면 1000이 포함하는 0의 수를 카운트 필요
                while (N % 10 != 0 && N <= M) { // N의 일의 자리 0으로 만들기.
                    cnt += calc(N, ten);
                    N++;
                }
                if(N>M) break;
                while (M % 10 != 9 && N <= M) {
                    cnt += calc(M, ten);
                    M--;
                }
                // if(N>M) break; 비교할 필요가 없다.
                // ten 자리에 0을 가지는 수 계산.
                cnt += (M/10 - N/10 +1 ) * ten;
                N /= 10;
                M /= 10;
                ten *= 10;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static long calc(long x, long ten) {
        long ret = 0;
        while (x > 0) {
            if(x%10 == 0) ret += ten;
            x /= 10;
        }
        return ret;
    }
}
