import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int min = 64;
    public static char arr[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        for (int i = 0; i<n; i++){
            String data = br.readLine();
            for (int j = 0; j<m; j++){
                arr[i][j] = data.charAt(j);
            }
        }

        for (int i = 0; i<n-7; i++){
            for (int j = 0; j<m-7; j++){
                find(i,j);
            }
        }
        System.out.println(min);
    }

    public static void find(int x, int y){
        char standard = arr[x][y];
        int count = 0;
        for(int i = x; i<x+8; i++){
            for (int j = y; j<y+8; j++){
                if(arr[i][j] != standard){
                    count++;
                }
                if (standard == 'B'){
                    standard = 'W';
                }else{
                    standard = 'B';
                }
            }
            if (standard == 'B'){
                standard = 'W';
            }else{
                standard = 'B';
            }
        }
        count = Math.min(count,64-count);
        min = Math.min(min,count);
    }
}