package Algorithm_study.week3;

import java.io.*;
import java.util.Stack;

public class BOJ_9093_Ver2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // �׽�Ʈ ���̽�

        while (T-- > 0) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine() + "\n";
            for (char ch : str.toCharArray()) {
                if (ch == ' ' || ch == '\n') {
                    while (!stack.isEmpty()) {
                        bw.write(stack.pop());
                    }
                    bw.write(ch);
                }
                else stack.push(ch);
            }
        }
        bw.flush();
    }
}
