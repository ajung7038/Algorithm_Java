package practice.Week03_01_Array_List;

import java.io.*;

public class BOJ_11720 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // ������ ����
        String str = br.readLine(); // ���� ���� �־��� ����

        int sum = 0; // ��ü �հ�

        // ���� ���ϱ�
        for (int i=0; i<N; i++) {
            sum += str.charAt(i) -'0';
        }

        System.out.println(sum);
        br.close();
    }
}
