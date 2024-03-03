
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _10816_3조_이현수 {
    public void solution(int[] sang, int[] target){
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int key : sang){
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for(int e : target){
            if(map.get(e) == null) sb.append("0 ");
            else sb.append(map.get(e)+" ");
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws IOException {
        int[] sang;
        int[] target;
        int i = 0;

        _10816_3조_이현수 s = new _10816_3조_이현수();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int sangSize = Integer.parseInt(br.readLine());
        sang = new int[sangSize];
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            sang[i] =Integer.parseInt(st.nextToken());
            i++;
        }
        i = 0;

        int targetSize = Integer.parseInt(br.readLine());
        target = new int[targetSize];
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            target[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        s.solution(sang, target);

    }
}
