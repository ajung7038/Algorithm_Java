package arr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2562 {
    public static void main(String[] args) throws IOException {

        int[] arr = new int[9];

        // 값 받기
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        int max = arr[0]; // 최댓값 저장 변수
        int index = 0; // 최댓값 인덱스

        // 최댓값 찾기
        for (int i=0; i<arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                index = i;
            }
        }
        System.out.println(max);
        System.out.println(index+1);
        bf.close();
    }
}
