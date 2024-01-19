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

        // ���� ��ȣ�� ������ŭ for�� ����
        for (int i=0; i<input.length(); i++) {
            // ��ȣ�� ���� ������ ���� �߰�
            if (input.charAt(i) == '(') {
                stack.push('(');
                continue;
            }

            // ��ȣ�� ���� ���� ��� ���ÿ��� '(' ������
            if (input.charAt(i) == ')') {
                stack.pop();

                // �ٷ� �� ���� ��ȣ�� ���� ������ -> ��������
                if (input.charAt(i-1) == '(') {
                    result += stack.size(); // ���� ������ �����ŭ �����ֱ�
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
