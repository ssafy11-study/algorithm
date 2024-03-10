// Subject: Study of Algorithm with SSAFY
// ProblemNo: B2239
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {

    static class Info{
        int tar, cost;
        Info(int...a){
            this.tar = a[0];
            this.cost = a[1];
        }
    }
    static int f(int r, int c){ return (r / 3) * 3 + (c / 3); }

    static void go(int r, int c){
        if(FLAG) return;
        if(c == 9){
            go(r + 1, 0);
            return;
        }
        if(r == 9){
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++) System.out.print(v[i][j]);
                System.out.println("");
            }
            FLAG = true;
            return;
        }
        if(v[r][c] > 0) go(r, c + 1);
        else{
            for(int i = 1; i <= 9; i++){
                if(chk[0][r][i] || chk[1][c][i] || chk[2][f(r, c)][i]) continue;
                chk[0][r][i] = chk[1][c][i] = chk[2][f(r, c)][i] = true;
                v[r][c] = i;
                go(r, c + 1);
                v[r][c] = 0;
                chk[0][r][i] = chk[1][c][i] = chk[2][f(r, c)][i] = false;
            }
        }
    }

    static final int MX = 999999;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int v[][];
    static boolean FLAG, chk[][][];
    static String s;
    
    public static void main(String[] args) throws Exception{
        
        v = new int[9][9];
        chk = new boolean[3][10][10];
        for(int i = 0; i < 9; i++){
            s = br.readLine();
            for(int j = 0; j < 9; j++) {
                v[i][j] = s.charAt(j) - '0';
                if(v[i][j] > 0){
                    chk[0][i][v[i][j]] = chk[1][j][v[i][j]] = chk[2][f(i, j)][v[i][j]] = true;
                }
            }
        }
        go(0, 0);
        
    }
}