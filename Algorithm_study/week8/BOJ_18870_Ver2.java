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
        // 배열에 넣기
        for (int i=0; i<N; i++) {
            arr[i] = sortedArr[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 정렬
        Arrays.sort(sortedArr);
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int index = 0;
        for (int i : sortedArr) {
            // 중복 값 제거
            if (!hashMap.containsKey(i)) {
                hashMap.put(i, index);
                index++;
            }
        }

        for (int k : arr) {
            int idx = hashMap.get(k); // 원본 배열 원소(key)에 대한 인덱스 값(value)을 가져온다
            sb.append(idx).append(" ");
        }

        System.out.println(sb);
    }
}
