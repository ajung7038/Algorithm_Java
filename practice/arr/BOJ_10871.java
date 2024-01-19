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
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 뭘 자를 건지 써 줘야 함

        int N = Integer.parseInt(st.nextToken()); // 정수 개수
        int X = Integer.parseInt(st.nextToken()); // 기준값

        int[] arr = new int[N]; // 정수들 저장하는 배열
        List<Integer> result = new ArrayList<>(); // x보다 작은 수를 저장하는 리스트

        st = new StringTokenizer(bf.readLine());


        // 배열에 값 집어넣기
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // x보다 작은 수를 result 배열에 저장
        for (int i=0; i<N; i++) {
            if (X > arr[i]) {
                result.add(arr[i]);
            }
        }

        // 리스트 값 출력
        Iterator<Integer> it = result.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        bf.close();
    }
}
