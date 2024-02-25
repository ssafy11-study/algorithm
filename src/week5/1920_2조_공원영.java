package SSAFY.study.week5.t1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/*
    baekjoon 1920 수 찾기
    N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
    모든 정수의 범위는 -2^31 보다 크거나 같고 2^31보다 작다.
    음수가 있네...
 */
public class Main {
    static int N, M;
    static int[] bs;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        bs = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            bs[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(bs);
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(binarySearch(x)) sb.append(1);
            else sb.append(0);
            sb.append('\n');
        }
        System.out.println(sb);
        br.close();
    }
    public static boolean binarySearch(int x) {
        int left = 0;
        int right = N-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (bs[mid] < x) {
                left = mid+1;
            } else if (bs[mid] > x) {
                right = mid-1;
            }else return true;
        }
        return false;
    }
}
