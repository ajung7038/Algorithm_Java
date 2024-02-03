package Algorithm_study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_24060 {

    static int[] A;
    static int[] tmp; // ���� �� ���� �迭
    static int result = -1; // ��� ����
    static int count = 0; // ���� Ƚ���� �����ϴ� ����
    static int K; // ���� Ƚ��
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // �迭 A�� ũ��
        K = Integer.parseInt(st.nextToken()); // ���� Ƚ��

        A = new int[N];
        tmp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());

        merge_sort(A, 0, N-1);

        System.out.println(result);
    }

    // �迭 �ɰ��� (�������� ����)
    private static void merge_sort(int[] A, int p, int r) {
        if (count > K) return; // ���� Ƚ���� ���� Ƚ������ ũ�� return
        if (p < r) {
            int q = (p+r) / 2;
            merge_sort(A, p, q);
            merge_sort(A, q+1, r);
            merge(A, p, q, r);
        }
    }

    // �迭 ����
    private static void merge(int[] A, int p, int q, int r) {
        int i = p;
        int j = q+1;
        int t = 0;

        while (i <= q && j <= r) {
            if (A[i] <= A[j]) {
                tmp[t++] = A[i++];
            } else tmp[t++] = A[j++];
        }

        // �� �����ϰ� ���� ���
        while (i<=q) tmp[t++] = A[i++]; // ���� �迭�� ���� ���
        while (j<=r) tmp[t++] = A[j++]; // ������ �迭�� ���� ���

        i = p; t = 0;
        while (i<=r) {
            count++;
            if (count == K) {
                result = tmp[t];
                break;
            }
            A[i++] = tmp[t++];
        }
    }
}
