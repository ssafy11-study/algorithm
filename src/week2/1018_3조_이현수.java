package solved.s4;
import java.util.Scanner;
public class ChessPainting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int col = scan.nextInt();
        int row = scan.nextInt();
        String str = new String();
        char[][] input = new char[col][row];

        for(int i = 0; i < col; i++){
            str = scan.next();
            for(int j = 0; j < row; j++){
                input[i][j] = str.charAt(j);
            }
        }
        System.out.println(valid(input, col, row));

    }
    static int valid(char[][] input, int col, int row){
        char[][] copy = new char[col][row];
        int minCount = 64;
        int maxCount = 0;
        int minCol = 0, minRow = 0;
        int cnt, num = 0;
        ;

        while(true){
            cnt = 0;
            // index증가 및 종료문
            if(minRow + 8 > row) {
                minCol++;
                minRow = 0;
            }
            if(minCol + 8 > col) break;
            // copy 배열 초기화
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    copy[i][j] = input[minCol + i][minRow + j];
                }
            }

            // 첫번째가 B인경우 num = 1;
            // 첫번째가 W인경우 num = 2;

            if(copy[0][0] == 'B') num = 1;
            else num = 2;
            switch(num) {
                case 1:
                    for (int i = 0; i < 8; i++) {
                        if (i % 2 == 0) { // i가 짝수행인 경우
                            if (copy[i][0] == 'W') {
                                copy[i][0] = 'B';
                                cnt++;
                            }
                            for (int j = 0; j < 8; j++) { // i=짝수 j=짝수인경우
                                if (j % 2 == 0) {
                                    if (copy[i][j] == 'W') {
                                        copy[i][j] = 'B';
                                        cnt++;
                                    }
                                } else { // i=짝수 j=홀수인경우
                                    if (copy[i][j] == 'B') {
                                        copy[i][j] = 'W';
                                        cnt++;
                                    }
                                }
                            }
                        } else { // i가 홀수행인 경우
                            if (copy[i][0] == 'B') {
                                copy[i][0] = 'W';
                                cnt++;
                            }
                            for (int j = 0; j < 8; j++) {
                                if (j % 2 == 0) { // i=홀수 j=짝수
                                    if (copy[i][j] == 'B') {
                                        copy[i][j] = 'W';
                                        cnt++;
                                    }
                                } else {// i=홀수 j=홀수
                                    if (copy[i][j] == 'W') {
                                        copy[i][j] = 'B';
                                        cnt++;
                                    }
                                }
                            }
                        }

                    }
                    break;
                case 2:
                    for (int i = 0; i < 8; i++) {
                        if (i % 2 == 0) { // i가 짝수행인 경우
                            if (copy[i][0] == 'B') {
                                copy[i][0] = 'W';
                                cnt++;
                            }
                            for (int j = 0; j < 8; j++) { // i=짝수 j=짝수인경우
                                if (j % 2 == 0) {
                                    if (copy[i][j] == 'B') {
                                        copy[i][j] = 'W';
                                        cnt++;
                                    }
                                } else { // i=짝수 j=홀수인경우
                                    if (copy[i][j] == 'W') {
                                        copy[i][j] = 'B';
                                        cnt++;
                                    }
                                }
                            }
                        } else { // i가 홀수행인 경우
                            if (copy[i][0] == 'W') {
                                copy[i][0] = 'B';
                                cnt++;
                            }
                            for (int j = 0; j < 8; j++) {
                                if (j % 2 == 0) { // i=홀수 j=짝수
                                    if (copy[i][j] == 'W') {
                                        copy[i][j] = 'B';
                                        cnt++;
                                    }
                                } else {// i=홀수 j=홀수
                                    if (copy[i][j] == 'B') {
                                        copy[i][j] = 'W';
                                        cnt++;
                                    }
                                }
                            }
                        }
                    }
                    break;
            }
            if(cnt < minCount){
                minCount = cnt;
            }
            if(cnt > 32){
                if(64 - cnt < minCount) minCount = 64 - cnt;
            }

            minRow++;
        }
        return minCount;
    }

}