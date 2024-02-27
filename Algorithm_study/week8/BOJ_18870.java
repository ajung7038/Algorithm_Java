package Algorithm_study.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 배열에 넣기
        for (int i=0; i<N; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }

        HashSet<Integer> hashSet = new HashSet<>();

        for (int i : arr) {
            hashSet.add(i);
        }
        System.out.println(hashSet);

        // 정렬
        ArrayList<Integer> arrayList = new ArrayList<>(hashSet);
        Collections.sort(arrayList);

        // 좌표 압축
        for (int i=0; i<N; i++) {
            for (int j=0; j<arrayList.size(); j++) {
                if (arr[i] == arrayList.get(j)) {
                     sb.append(j).append(" ");
                }
            }
        }

        System.out.println(sb);
    }
}
