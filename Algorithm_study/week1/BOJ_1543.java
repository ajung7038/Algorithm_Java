package Algorithm_study.week1;

import java.io.*;

/**
 * ���� �˻�.java
 */
public class BOJ_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String findStr = br.readLine();
        String str = br.readLine();

        int size = str.length(); // �־��� �ܾ��� ����
        int count = 0; // �ܾ� ����

        // �ߺ� ������ ���� str�� ���̸�ŭ !�� ġȯ
        // ex) abababab -> !!!b!!!b
        findStr = findStr.replace(str, "!".repeat(str.length()));

        for (int i=0; i<findStr.length(); i++) {
            if (findStr.charAt(i) == '!')
                count += 1;
        }

        // !�� ���� / �ܾ� ����
        System.out.println(count/size);
    }
}
