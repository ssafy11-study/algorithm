import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str, sub;
        Stack<Character> arr;
        int top;
        boolean flag;

        while((str = br.readLine()) != null){ // 문자열 단위
            flag = true;
            top = 0;
            if(str.equals(".")){
                break;
            }
            arr = new Stack<>();
            st = new StringTokenizer(str);

            while(st.hasMoreTokens()){ // 단어 단위
                sub = st.nextToken();
                for(int i = 0; i < sub.length(); i++){ // 글자 단위
                    if(top == 0 && sub.charAt(i) == ')'){
                        flag = false;
                        break;
                    }
                    else if(top == 0 && sub.charAt(i) == ']'){
                        flag = false;
                        break;
                    }

                    if(sub.charAt(i) == '(' || sub.charAt(i) == '['){
                        arr.push(sub.charAt(i));
                        top++;
                    }
                    else if(sub.charAt(i) == ')' && top > 0){
                        if(arr.peek() == '(') {
                            arr.pop();
                            top--;
                        }
                        else {
                            flag = false;
                            break;
                        }
                    }
                    else if(sub.charAt(i) == ']' && top > 0){
                        if(arr.peek() == '[') {
                            arr.pop();
                            top--;
                        }
                        else {
                            flag = false;
                            break;
                        }
                    }
                }
                if(sub.contains(".")) break; // 온점이 찍힌 경우 해당 문자열 끝
            }
            if(!arr.isEmpty()) flag = false;

            if(flag == true) System.out.println("yes");
            else System.out.println("no");
        }
    }
}