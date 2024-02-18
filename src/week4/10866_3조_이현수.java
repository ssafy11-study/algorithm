package study;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class _10866_3조_이현수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int inputSize = Integer.parseInt(br.readLine());
        ArrayList<Integer> q = new ArrayList<>(inputSize);
        int cnt = 0, num = 0;
        String str, order;

        while (cnt < inputSize) {
            str = br.readLine();
            st = new StringTokenizer(str);

            order = st.nextToken();
            if(st.hasMoreTokens()){
                num = Integer.parseInt(st.nextToken());
            }
            switch (order){
                case "push_front":{
                    q.add(0, num);
                    break;
                }
                case "push_back":{
                    q.add(num);
                    break;
                }
                case "pop_front":{
                    if(q.isEmpty() == true){
                        System.out.println(-1);
                    }
                    else{
                        System.out.println(q.get(0));
                        q.remove(0);
                    }
                    break;
                }
                case "pop_back":{
                    if(q.isEmpty() == true){
                        System.out.println(-1);
                    }
                    else{
                        System.out.println(q.get(q.size()-1));
                        q.remove(q.size()-1);
                    }
                    break;
                }
                case "size":{
                    System.out.println(q.size());
                    break;
                }
                case "empty":{
                    if(q.isEmpty() == true) System.out.println(1);
                    else System.out.println(0);
                    break;
                }
                case "front":{
                    if(q.isEmpty() == true){
                        System.out.println(-1);
                    }
                    else{
                        System.out.println(q.get(0));
                    }
                    break;
                }
                case "back":{
                    if(q.isEmpty() == true){
                        System.out.println(-1);
                    }
                    else{
                        System.out.println(q.get(q.size() - 1));
                    }
                    break;
                }
            }
            cnt++;
        }
    }
}
