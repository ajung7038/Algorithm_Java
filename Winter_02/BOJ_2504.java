package Winter_02;

import java.io.InputStreamReader;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_2504 {

    static Stack<String> stack;
    static char count;
    static int result;
    static String operator = "+";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()) {
            String current = st.nextToken();

            if (current.equals("(") || current.equals("[")) {
                stack.push(current);
                operator = "+";
            }
            else if (current.equals("+") || current.equals("*")) {
                count += stack.pop().charAt(0);
                count += stack.pop().charAt(0);

                // result 계산 로직
                // +3*3
            }
            else if (current.equals("]")) {
                String c = stack.pop();
                if (c.equals("+") || c.equals("*")) {
                    count += stack.pop().charAt(0);
                    count += stack.pop().charAt(0);
                    c = stack.pop();
                }
                operator = "*";

                // 짝이 맞으면
                if (c.equals("[")) {
                    if (!stack.empty()) {
                        stack.push("3");
                        stack.push(operator);
                    } else { // 스택이 비어 있으면 result로 옮기기
                        count += operator.charAt(0);
                        count += 3;
                    }
                    operator = "*";
                }
            }
            else if (current.equals(")")) {
                String c = stack.pop();
                if (c.equals("+") || c.equals("*")) {
                    count += stack.pop().charAt(0);
                    count += stack.pop().charAt(0);
                    c = stack.pop();
                }
                // 짝이 맞으면
                if (c.equals("(")) {
                    if (!stack.empty()) {
                        stack.push("2");
                        stack.push(operator);
                    } else { // 스택이 비어 있으면 result로 옮기기
                        count += operator.charAt(0);
                        count += 2;
                    }
                    operator = "*";
                }
            }
        }

        System.out.println(count);
    }
}
