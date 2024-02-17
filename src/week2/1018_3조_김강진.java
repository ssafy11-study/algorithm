// Subject: Study of Algorithm with SSAFY
// ProblemNo: 1018
// Language: JAVA
// Author: KimKangjin

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static int checker(String[][] board, int r, int c){
        boolean checker = false; // 기본 white로 초기화

        if (board[r][c].equals("B")){
            checker = true;    // 첫번째 칸이 black 인경우 checker = true
        }
        int cnt = 0;

        for (int i=r;i<r+8;i++){
            for (int j=c;j<c+8;j++){
                if (checker){
                    // 이전값이 검정일 경우 바꿔야 함
                    if(board[i][j].equals("W")){
                        cnt ++;
                    }
                } else {
                    if(board[i][j].equals("B")){
                        cnt ++;
                    }
                }
                checker = !checker;
            }
            checker = !checker;
        }

        return Math.min(cnt,64-cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String [][] board = new String[n][m];

        String tmpString;
        for (int i=0;i<n;i++){
            tmpString = br.readLine();
            for (int j=0;j<m;j++){
                board[i][j] = String.valueOf(tmpString.charAt(j));
            }
        }

        int [][] cntBoard = new int[m-7][n-7];
        int tmpMin; // 최댓값으로 초기화
        int min=64;

        for (int i=0;i<n-7;i++){
            for (int j=0;j<m-7;j++){
                tmpMin = checker(board,i,j);
                min = Math.min(tmpMin,min);
//                if (i == 4 && j == 0){
//                    System.out.printf("TempMin : %d, Min , %d\n",tmpMin,min);
//                }
            }
        }

        System.out.println(min);
    }

}

