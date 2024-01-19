package Algorithm_study.week2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * �迭 ������.java
 */
public class BOJ_17276 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // �׽�Ʈ ���̽��� �� (�� �� �ݺ��� ����)

        // �׽�Ʈ ���̽� �ݺ�
        for (int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // �׽�Ʈ ���̽����� ���� �ٸ��Ƿ� ���������� ����
            int arrSize = Integer.parseInt(st.nextToken()); // �迭 ũ��
            int degree = Integer.parseInt(st.nextToken()); // ����
            int[][] arr = new int[arrSize+1][arrSize+1]; // 2���� �迭
            int rotate = Math.abs(degree) / 45; // ȸ�� ��

            // n * n �迭�̹Ƿ� �߰� ��ǥ�� x�� == y�� (�ϳ��� ����)
            int middle = (arrSize+1)/2; // �߰� ��ǥ ��

            // ���� Ȯ�� (�������� �������) && rotate
            if (degree > 0) {
                // �ݺ�
                for (int k=0; k<rotate; k++) {
                    // ���� ���� -> �ٲ� practice.arr ���� �� �ٲ��� �ʵ��� newArr ����
                    int newArr[][] = new int[arrSize+1][arrSize+1];

                    // 2���� �迭�� clone()���� ���� ���簡 �� ��.
                    // �� �ึ�� clone() �ϰų� ���� �������� ���� ���� �����ϴ� ���ۿ� ����. �Ǵ� arraycopy() ���
                    for (int a = 1; a<=arrSize; a++) {
                        for (int b = 1; b<=arrSize; b++) {
                            newArr[a][b] = arr[a][b];
                        }
                    }

                    for (int j = 1; j <= arrSize; j++) {
                        if (k == 0) {
                            st = new StringTokenizer(br.readLine());
                        }
                        // �� �پ� �־��ֱ� -> Ȯ���ؼ� practice.arr �迭�� �ֱ� (�ᱣ��)
                        // k : ���� �� �ݺ��ϴ��� Ȯ��
                        clockwise(j, arrSize, st, arr, newArr, middle, k);
                    }
                }
            }
            else {
                for (int k=0; k<rotate; k++) {
                    // ���� ���� -> �ٲ� practice.arr ���� �� �ٲ��� �ʵ��� newArr ����
                    int newArr[][] = new int[arrSize+1][arrSize+1];

                    // 2���� �迭 ���� ����
                    for (int a = 0; a<arr.length; a++) {
                        newArr[i] = arr[i].clone();
                    }
                    
                    for (int j = 1; j <= arrSize; j++) {
                        if (k == 0) {
                            st = new StringTokenizer(br.readLine());
                        }
                        counterclockwise(j, arrSize, st, arr, newArr, middle, k);
                    }
                }
            }

            // ���
            for (int j=1; j<=arrSize; j++) {
                for (int k=1; k<=arrSize; k++) {
                    System.out.print(arr[j][k] + " ");
                }
                System.out.println();
            }
        }

        br.close();
    }

    // �ð� ���� �迭 ��ȸ
    // r : ���� �� �ݺ� Ȯ��
    public static void clockwise(int j, int arrSize, StringTokenizer st, int[][] arr, int[][] newArr, int middle, int r) {

        // �迭 ���� ��ȸ
        for (int k = 1; k <= arrSize; k++) {
            int num;
            if (r == 0) {
                num = Integer.parseInt(st.nextToken());
            }
            else {
                num = newArr[j][k]; // 5�� �ݺ�
            }

            // �� �밢�� => ���� ��ȭ
            // �� �밢�� Ȯ�� : ���� (x, y)���� x == y�̸�
            if (j == k) {
                // X�� �� �밢���� ��� ���� �ű�� (1�� ����)
                arr[j][middle] = num;
            }

            // ��� �� => ���� ��ȭ
            // ex) (1, 3) -> (1, 5) / (2, 3) -> (2, 4) ... (5, 3) -> (5, 1)
            else if (k == middle) {
                // X�� ��� ���� �� �밢������ �ű�� (2�� ����)
                arr[j][arrSize - j + 1] = num;
            }

            // �� �밢�� => �ุ ��ȭ
            // (1, 5), (2, 4), (3, 3), (4, 2), (5, 1)
            else if (j == (arrSize - k + 1)) {
                // X�� �� �밢���� ��� ������ �ű�� (3�� ����)
                arr[middle][k] = num;
            }

            // ��� �� => �ุ ��ȭ
            else if (j == middle) {
                // X�� ��� ���� �� �밢������ �ű��
                arr[k][k] = num;
            }
            else {
                arr[j][k] = num;
            }
        }
    }


    // �ݽð� ���� �迭 ��ȸ
    public static void counterclockwise(int j, int arrSize, StringTokenizer st, int[][] arr, int[][] newArr, int middle, int r) {
        // �迭 ���� ��ȸ
        for (int k = 1; k <= arrSize; k++) {
            int num;

            if (r == 0) {
                num = Integer.parseInt(st.nextToken());
            }
            else {
                num = newArr[j][k];
            }

            // �� �밢��
            // �� �밢�� Ȯ�� : ���� (x, y)���� x == y�̸�
            if (j == k) {
                // X�� �� �밢���� ��� ������ �ű�� (3�� ����)
                arr[middle][k] = num;
            }

            // ��� ��
            // (1, 3) -> (1, 1) / (2, 3) -> (2, 2)
            else if (k == middle) {
                // X�� ��� ���� �� �밢������ �ű�� (1�� ����)
                arr[j][j] = num;
            }

            // �� �밢��
            // (1, 5), (2, 4), (3, 3), (4, 2), (5, 1)
            else if (k == (arrSize - j + 1)) {
                // X�� �� �밢���� ��� ���� �ű�� (1�� ����)
                arr[j][middle] = num;
            }

            // ��� ��
            // (3,1) -> (5,1) / (3, 2) -> (4, 2) ...
            else if (j == middle) {
                // X�� ��� ���� �� �밢������ �ű��
                arr[arrSize - k + 1][k] = num;
            }
            else {
                arr[j][k] = num;
            }
        }
    }
}
