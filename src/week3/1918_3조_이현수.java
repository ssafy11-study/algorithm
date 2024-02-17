package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class _1918_3조_이현수 {
    static ArrayList<Character> operArr = new ArrayList<>(Arrays.asList('+', '-', '*', '/'));
    static StringBuilder answer = new StringBuilder();

    static void solution(char[] charArr){
        Stack<Character> stack = new Stack<>();

        for(char c : charArr){
            if(operArr.contains(c)){
                while(!stack.isEmpty() && rank(stack.peek()) >= rank(c)) answer.append(stack.pop()); // 5회전 answer
                // 5회전 stack.peek = '(' (rank = 0) >= '*' (rank = 2) = false

                stack.push(c);
                // 2회전(스택 비어있음) 스택: [*]
                // 5회전 스택: [*,(,+]
            }
            else if(c == '(') stack.push(c); // 3회전 스택: *, (


            else if(c == ')'){
                while(!stack.isEmpty() && stack.peek() != '(') answer.append(stack.pop()); // '+' pop, 현재 스택: [*]
                stack.pop(); // 여는 괄호 제거
            }

            else answer.append(c); // A, 알파벳인 경우 answer 에 넣기
            // 1회전: answer = A
            // 4회전: answer = AB
            // 6회전: answer = ABC
        }
        while(!stack.isEmpty()) answer.append(stack.pop());
    }
    static int rank(char letter){
        if(letter == '*' || letter == '/') return 2;
        else if(letter == '+' || letter == '-') return 1;
        else return 0;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArr = br.readLine().toCharArray();
        solution(charArr);

        System.out.println(answer);
    }
}
