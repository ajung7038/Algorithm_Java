package practice.arr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 정수 개수
        int[] nums = new int[N]; // 정수 저장 배열

        StringTokenizer st = new StringTokenizer(bf.readLine());

        
        // 정수 저장
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int max = nums[0]; // 최댓값
        int min = nums[0]; // 최솟값

        // 최댓값, 최솟값 확인
        for (Integer i : nums) {
            if (max < i)
                max = i;
            if (min > i)
                min = i;
        }

        // 최댓값, 최솟값 출력
        System.out.print(min + " " + max);
    }
}
