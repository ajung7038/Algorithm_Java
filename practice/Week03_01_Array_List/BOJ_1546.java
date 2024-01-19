package practice.Week03_01_Array_List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // ���� ��
        double[] score = new double[N];
        double max = 0; // ���� �ְ���
        double sum = 0; // ���� �հ�

        StringTokenizer st = new StringTokenizer(br.readLine());

        // score �ޱ� && �ְ��� ã��
        for (int i=0; i<N; i++) {
            score[i] = Integer.parseInt(st.nextToken());

            // �ְ��� ã��
            if (score[i] > max)
                max = score[i];
        }

        // ��� ���ϱ�
        for (int i=0; i<N; i++) {
            sum += score[i] / max * 100;
        }

        System.out.println(sum/N);
    }
}
