package Algorithm_study.week2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * �迭 ������.java
 */
public class BOJ_17276 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine()); // �׽�Ʈ ���̽��� �� (�� �� �ݺ��� ����)

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int arrSize = Integer.parseInt(st.nextToken()); // �迭 ũ��
        int degree = Integer.parseInt(st.nextToken()); // ����
        int[][] arr = new int[arrSize+1][arrSize+1]; // 2���� �迭


        // �׽�Ʈ ���̽� �ݺ�
        for (int i=0; i<T; i++) {
            // ���̽� ���̽����� �߰����� �ٸ��Ƿ� ���������� ����
            // n * n �迭�̹Ƿ� �߰� ��ǥ�� x�� == y�� (�ϳ��� ����)
            int middle = (arrSize+1)/2; // �߰� ��ǥ ��
            int[][] newArr = new int[arrSize+1][arrSize+1]; //arr.clone(); // �� ���� ���� 2���� �迭 (���)

            // �ʱ� �迭 ���� (1���� 5����, 0�� ��� X)
            for (int j=1; j<=arrSize; j++) {
                for (int k=1; k<=arrSize; k++) {
                    // ex) (1, 1) -> 1 / (5, 5) -> 25
                    arr[j][k] = (j-1) * arrSize + k;
                    newArr[j][k] = (j-1) * arrSize + k;
                }
            }

            // �迭 ���� ��ȸ
            for (int j=1; j<=arrSize; j++) {
                for (int k=1; k<=arrSize; k++) {

                    // �� �밢�� => ���� ��ȭ
                    // �� �밢�� Ȯ�� : ���� (x, y)���� x == y�̸�
                    if (j == k) {
                        // X�� �� �밢���� ��� ���� �ű�� (1�� ����)
                        newArr[j][middle] = arr[j][k];
                    }

                    // ��� �� => ���� ��ȭ
                    // ex) (1, 3) -> (1, 5) / (2, 3) -> (2, 4) ... (5, 3) -> (5, 1)
                    if (k == middle) {
                        // X�� ��� ���� �� �밢������ �ű�� (2�� ����)
                        newArr[j][arrSize-j+1] = arr[j][k];
                    }

                    // �� �밢�� => �ุ ��ȭ
                    // (1, 5), (2, 4), (3, 3), (4, 2), (5, 1)
                    if (j == (arrSize - k + 1)) {
                        // X�� �� �밢���� ��� ������ �ű�� (3�� ����)
                        newArr[middle][k] = arr[j][k];
                    }

                    // ��� �� => �ุ ��ȭ
                    if (j == middle) {
                        newArr[k][k] = arr[j][k];
                    }
                }
            }

            // ���
            for (int j=1; j<=arrSize; j++) {
                for (int k=1; k<=arrSize; k++) {
                    System.out.print(newArr[j][k] + " ");
                }
                System.out.println();
            }
        }
    }
}
