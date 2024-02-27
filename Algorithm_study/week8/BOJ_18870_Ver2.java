package Algorithm_study.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18870_Ver2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] sortedArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        // �迭�� �ֱ�
        for (int i=0; i<N; i++) {
            arr[i] = sortedArr[i] = Integer.parseInt(st.nextToken());
        }

        // �迭 ����
        Arrays.sort(sortedArr);
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int index = 0;
        for (int i : sortedArr) {
            // �ߺ� �� ����
            if (!hashMap.containsKey(i)) {
                hashMap.put(i, index);
                index++;
            }
        }

        for (int k : arr) {
            int idx = hashMap.get(k); // ���� �迭 ����(key)�� ���� �ε��� ��(value)�� �����´�
            sb.append(idx).append(" ");
        }

        System.out.println(sb);
    }
}
