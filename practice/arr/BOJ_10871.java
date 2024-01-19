package practice.arr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine()); // �� �ڸ� ���� �� ��� ��

        int N = Integer.parseInt(st.nextToken()); // ���� ����
        int X = Integer.parseInt(st.nextToken()); // ���ذ�

        int[] arr = new int[N]; // ������ �����ϴ� �迭
        List<Integer> result = new ArrayList<>(); // x���� ���� ���� �����ϴ� ����Ʈ

        st = new StringTokenizer(bf.readLine());


        // �迭�� �� ����ֱ�
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // x���� ���� ���� result �迭�� ����
        for (int i=0; i<N; i++) {
            if (X > arr[i]) {
                result.add(arr[i]);
            }
        }

        // ����Ʈ �� ���
        Iterator<Integer> it = result.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        bf.close();
    }
}
