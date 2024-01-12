package Algorithm_study.week2;

import java.io.*;

public class BOJ_1193 {
    public static void main(String[] args) throws IOException {
        // 2���� �迭
        // (i, j)���� i == 1�̸� ���������� �̵�
        // (i, j)���� j == 1�̸� �Ʒ��� �̵�
        // else : i--, j++ (1�� ���� ������)

        // �Է�
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        Long[][] board = new Long[10000000][10000000];

        for (int i=1; i<=X; i++) {
            for (int j=1; j<=X; j++) {
                if (i == 1) {
                    j += 1;
                }
                else if (j == 1) {
                    i += 1;
                }
                else {
                    i--;
                    j++;
                }
            }
        }
    }
}
