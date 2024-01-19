package practice.Week03_01_Array_List;

import java.io.*;

public class BOJ_11720 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 숫자의 개수
        String str = br.readLine(); // 공백 없이 주어진 숫자

        int sum = 0; // 전체 합계

        // 숫자 더하기
        for (int i=0; i<N; i++) {
            sum += str.charAt(i) -'0';
        }

        System.out.println(sum);
        br.close();
    }
}
