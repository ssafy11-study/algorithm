import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] map = new int[21];
    static int N;
    static int idx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        // add: 1 -> 1 0->1 or 연산, mask : 1
        //remove : 0-> 0 1-> 0 and 연산 mask: 0
        //check: 자기 자신 그대로 1->1 0->0 and 연산 mask:1 //print
        // toggle: 1->0 0->1 xor mask : 1
        // all
        // empty
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            String comment = input[0];
            if(input.length>1){
                String s_idx= input[1];
                idx = Integer.parseInt(s_idx);
            }
//            System.out.println(idx);
            switch(comment){
                case "add":
                    map[idx] = map[idx] | 1;
                    break;
                case "check":
                    sb.append(map[idx] & 1).append("\n");
                    break;
                case "remove":
                    map[idx] = map[idx] & 0;
                    break;
                case "toggle":
                    map[idx] = ~map[idx] ;
                    break;
                case "all":
                    for(int j=1; j<21; j++){
                        map[j] = 1;
                    }
                    break;
                case "empty":
                    Arrays.fill(map,0);
                    break;

            }
        }
        System.out.println(sb.toString());
    }
}
