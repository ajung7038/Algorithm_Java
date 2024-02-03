package Algorithm_study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_24060 {

    static int[] A;
    static int[] tmp; // 정렬 후 저장 배열
    static int result = -1; // 결과 저장
    static int count = 0; // 저장 횟수를 저장하는 변수
    static int K; // 저장 횟수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 배열 A의 크기
        K = Integer.parseInt(st.nextToken()); // 저장 횟수

        A = new int[N];
        tmp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());

        merge_sort(A, 0, N-1);

        System.out.println(result);
    }

    // 배열 쪼개기 (오름차순 정렬)
    private static void merge_sort(int[] A, int p, int r) {
        if (count > K) return; // 저장 횟수가 진행 횟수보다 크면 return
        if (p < r) {
            int q = (p+r) / 2;
            merge_sort(A, p, q);
            merge_sort(A, q+1, r);
            merge(A, p, q, r);
        }
    }

    // 배열 병합
    private static void merge(int[] A, int p, int q, int r) {
        int i = p;
        int j = q+1;
        int t = 0;

        while (i <= q && j <= r) {
            if (A[i] <= A[j]) {
                tmp[t++] = A[i++];
            } else tmp[t++] = A[j++];
        }

        // 다 정렬하고 남은 경우
        while (i<=q) tmp[t++] = A[i++]; // 왼쪽 배열이 남은 경우
        while (j<=r) tmp[t++] = A[j++]; // 오른쪽 배열이 남은 경우

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
