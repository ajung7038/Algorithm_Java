package practice.Bronze;

import java.util.Scanner;

public class BOJ_3046 {
    // R2 구하기
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int R1 = scan.nextInt();
        int S = scan.nextInt(); // 평균

        // S = (R1+R2)/2
        // => R2 = S*2 - R1

        // 구해야 할 숫자 R2 선언
        int R2 = S*2 - R1;

        // R2 출력
        System.out.println(R2);

        // 스캐너 닫기
        scan.close();
    }
}
