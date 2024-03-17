import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean flag = false;
        int size = scan.nextInt();
        Stack<Integer> st = new Stack<Integer>();
        Queue<String> tmp = new LinkedList<>();
        int value = 1; // 1부터 오름차순
        int cnt = 0;
        int[] tArr = new int[size];
        int[] iArr = new int[size + 1];
        for(int i = 0; i < size; i++) tArr[i] = scan.nextInt();

        int target = tArr[0];
        while(true){
            // 1단계 : 초기 target값 까지 ++후 target = value이면 멈춤
            if(target > value){
                st.push(value);
                tmp.add("+");
                value++;
                target = tArr[cnt];
                if(cnt == size) {
                    break;
                }
            }
            // 2단계 : value = target이면 value를 넣고 그자리에서 스택 pop
            if(target == value){
                st.push(value);
                tmp.add("+");
                value++;
                iArr[cnt] = st.pop();
                tmp.add("-");
                cnt++;
                if(cnt == size) {
                    break;
                }
                target = tArr[cnt];
            }
            // 3단계 : target < value이면 원하는 target이 배열안에 들어있으니 계속 pop
            if(target < value){
                iArr[cnt] = st.pop();
                tmp.add("-");
                if(tArr[cnt] != iArr[cnt]) {
                    flag = true;
                    break;
                }
                cnt++;
                if(cnt == size) {
                    break;
                }
                target = tArr[cnt];
            }



        }
        if(flag == true) System.out.println("NO");
        else{
            while(!tmp.isEmpty()){
                System.out.println(tmp.poll());
                if(tmp.isEmpty() == true) break;
            }
        }

    }
}
