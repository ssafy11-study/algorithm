import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();
            if (str.equals("0")) {
                break;
            }
            int flag = 1;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != str.charAt(str.length()-i-1)) {
                    System.out.println("no");
                    flag = 0;
                    break;
                }
            }
            if (flag == 1){
                System.out.println("yes");
            }
        }
    }
}