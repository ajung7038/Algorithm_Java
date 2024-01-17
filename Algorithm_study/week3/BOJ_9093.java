package Algorithm_study.week3;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_9093 {
    static Stack<String> stack = new Stack<>();
    static String sentence = "";

    // 접근
    // 1. Stack 사용
    // 2. TestCase만큼 단어 스택에 집어 넣고 peek() 메소드로 뽑기
    // * 단어의 길이는 최대 20, 문장의 길이는 최대 1000 => 이중 for문 X
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

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

        String result = ""; // 단어 저장 변수

        for (int i=0; i<word.length(); i++) {
            result += stack.pop();
        }
        return result;
    }
}
