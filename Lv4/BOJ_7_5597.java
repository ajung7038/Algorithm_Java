package Lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_7_5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[30];
        int n1, n2;


        // 0���� �ʱ�ȭ
        for (int i=0; i<30; i++) arr[i] = 0;

        // �⼮ ��ȣ 1�� �ٲٱ�
        for (int i=0; i<28; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num] = 1;
        }

        for (int i : arr) {
            if (i == 0) n1 = i;
        }
    }
}
