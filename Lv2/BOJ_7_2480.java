package Lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_7_2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a, b, c;
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // ���� ��� ������ �ٸ� ���
        if (a != b && b != c && a != c) {
            int max = Math.max(a, Math.max(b, c));
            System.out.println(max * 100);
        }
        // 3���� ������ ��� ���� ���
        else if (a == b && a == c) {
            System.out.println(10000 + a * 1000);
        }
        // a�� bȤ�� c���� ���� ���
        else if(a == b || a == c) {
            System.out.println(1000 + a * 100);
        }
        // b�� c�� ���� ���
        else {
            System.out.println(1000 + b * 100);
        }
    }
}