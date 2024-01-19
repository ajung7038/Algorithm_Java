package Algorithm_study.week3;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        for (int i=0; i<T; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            for (char c : str.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                } else if (stack.isEmpty()) {
                    stack.push(c);
                    break;
                } else if (stack.get(stack.size()-1) == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                    break;
                }

            }
            if (stack.isEmpty()) {
                bw.write("YES");
            } else bw.write("NO");
            bw.write("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
