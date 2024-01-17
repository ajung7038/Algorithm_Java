package Algorithm_study.week3;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_9093 {
    static Stack<String> stack = new Stack<>();
    static String sentence = "";

    // ����
    // 1. Stack ���
    // 2. TestCase��ŭ �ܾ� ���ÿ� ���� �ְ� peek() �޼ҵ�� �̱�
    // * �ܾ��� ���̴� �ִ� 20, ������ ���̴� �ִ� 1000 => ���� for�� X
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // �׽�Ʈ ���̽��� ��

        for (int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                sentence += changeWord(String.valueOf(st.nextToken())) + " ";
            }
            sentence += "\n";
        }
        System.out.println(sentence);

    }

    public static String changeWord(String word) {
        for (int i=0; i<word.length(); i++) {
            stack.push(String.valueOf(word.charAt(i)));
        }

        String result = ""; // �ܾ� ���� ����

        for (int i=0; i<word.length(); i++) {
            result += stack.pop();
        }
        return result;
    }
}
