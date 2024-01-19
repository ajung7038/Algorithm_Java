package Algorithm_study.week3;

import java.io.*;
import java.util.Stack;


public class BOJ_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        int result = 0;

        // 들어온 괄호의 개수만큼 for문 돌기
        for (int i=0; i<input.length(); i++) {
            // 괄호가 열려 있으면 스택 추가
            if (input.charAt(i) == '(') {
                stack.push('(');
                continue;
            }

            // 괄호가 닫혀 있을 경우 스택에서 '(' 꺼내기
            if (input.charAt(i) == ')') {
                stack.pop();

                // 바로 전 들어온 괄호가 열려 있으면 -> 레이저면
                if (input.charAt(i-1) == '(') {
                    result += stack.size(); // 현재 스택의 사이즈만큼 더해주기
                } else {
                    result ++;
                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
