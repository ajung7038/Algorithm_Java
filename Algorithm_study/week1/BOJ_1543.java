package Algorithm_study.week1;

import java.io.*;

/**
 * 문서 검색.java
 */
public class BOJ_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String findStr = br.readLine();
        String str = br.readLine();

        int size = str.length(); // 주어진 단어의 길이
        int count = 0; // 단어 개수

        // 중복 방지를 위해 str의 길이만큼 !로 치환
        // ex) abababab -> !!!b!!!b
        findStr = findStr.replace(str, "!".repeat(str.length()));

        for (int i=0; i<findStr.length(); i++) {
            if (findStr.charAt(i) == '!')
                count += 1;
        }

        // !의 개수 / 단어 길이
        System.out.println(count/size);
    }
}
