package Winter_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2504_Ver2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String N = br.readLine(); // °ýÈ£

        int result = 0;
        int count = 1;

        for (int i=0; i<N.length(); i++) {
            char current = N.charAt(i);
            if (current == '(') {
                stack.push(current);
                count *= 2;
            } else if (current == '[') {
                stack.push(current);
                count *= 3;
            } else if (current == ')') {
                if (stack.isEmpty() || stack.peek()!='(') {
                    result = 0;
                    break;
                } else if (N.charAt(i-1) == '(') {
                    result += count;
                }
                stack.pop();
                count/=2;
            } else if (current == ']') {
                if (stack.isEmpty() || stack.peek()!= '[') {
                    result = 0;
                    break;
                } else if (N.charAt(i-1) == '[') {
                    result += count;
                }
                stack.pop();
                count /= 3;
            }
        }

        br.close();
        if (!stack.isEmpty()) System.out.println(0);
        else System.out.println(result);
    }
}
