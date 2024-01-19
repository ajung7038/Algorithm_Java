package practice.arr;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()); // �ٱ��� ����
        int M = Integer.parseInt(st.nextToken()); // �� �ִ� Ƚ��

        int[] basket = new int[N];

//         �ٱ��� �� ��ȣ �ʱ�ȭ (0)
        for (int i=0; i<N; i++) {
            basket[i] = 0;
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(bf.readLine());
            // i�� �ε������� j�� �ε������� k ����
            int startIndex = Integer.parseInt(st.nextToken());
            int lastIndex = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            for (int j=startIndex-1; j<lastIndex; j++) {
                basket[j] = value;
            }
        }

        // ���
        for (int i = 0; i<basket.length; i++) {
            bw.write(basket[i] + " ");
        }

        bf.close();
        bw.flush();
        bw.close();
    }
}
